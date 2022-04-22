package com.xiaozheng.audit.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.xiaozheng.audit.dao.ProcInstanceDao;
import com.xiaozheng.audit.dao.ProcTaskInstanceDao;
import com.xiaozheng.audit.dao.ProcUserGroupDao;
import com.xiaozheng.audit.feign.EmployeeApi;
import com.xiaozheng.audit.service.ProcInstanceService;
import com.xiaozheng.audit.service.ProcessService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.BeanMapUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
import com.xiaozheng.model.proc.ProcInstanceEntity;
import com.xiaozheng.model.proc.ProcTaskInstanceEntity;
import com.xiaozheng.model.proc.ProcUserGroupEntity;
import com.xiaozheng.model.vo.proc.ProcessVo;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.IdentityLink;
import org.activiti.engine.task.Task;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 流程 拓展表  -- 业务流程实例表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Service("procInstanceService")
public class ProcInstanceServiceImpl extends ServiceImpl<ProcInstanceDao, ProcInstanceEntity> implements ProcInstanceService {

    @Autowired
    private EmployeeApi employeeApi;

    /**
     * 流程部署 activiti 暴漏的接口
     */
    /*@Autowired
    private RepositoryService repositoryService;*/

    @Autowired
    private ProcessService processService;

    /*@Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;*/

    @Autowired
    private ProcTaskInstanceDao procTaskInstanceDao;

    @Autowired
    private ProcUserGroupDao procUserGroupDao;


    /**
     * 查询申请列表
     * 参数:
     * page,size
     * 业务参数:
     * 审批类型
     * 审批状态(多个,每个状态之间使用","隔开)
     * 当前节点的待处理人
     *
     * @param params 请求集合
     * @return 所有数据
     */
    @Override
    public PageUtils<ProcInstanceEntity> queryPage(ProcInstanceEntity procInstance, Map<String, Object> params) {
        IPage<ProcInstanceEntity> page = this.page(
                new Query<ProcInstanceEntity>().getPage(params),
                Wrappers.lambdaQuery(procInstance)
                        .eq(StringUtils.isNotBlank(procInstance.getProcessKey()), ProcInstanceEntity::getProcessKey, procInstance.getProcessKey())
                        .in(StringUtils.isNotBlank(procInstance.getProcessState()), ProcInstanceEntity::getProcessState, StringUtils.isNotBlank(procInstance.getProcessState())  ? (Object) procInstance.getProcessState().split(",") : null)
                        .like(StringUtils.isNotBlank(procInstance.getProcCurrNodeUserId()), ProcInstanceEntity::getProcCurrNodeUserId, procInstance.getProcCurrNodeUserId())
                        .eq(StringUtils.isNotBlank(procInstance.getUserId()), ProcInstanceEntity::getUserId, procInstance.getUserId())
        );
        return new PageUtils(page);
    }

    /**
     * 流程申请
     *
     * @param processVo 实体对象
     * @return 新增结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveProcess(ProcessVo processVo) throws CommonException {

        ProcInstanceEntity procInstanceEntity = new ProcInstanceEntity();

        R<EmUserCompanyPersonalEntity> entityR = employeeApi.info(processVo.getUserId());
        if (entityR.getCode() != ResultCode.SUCCESS.code() || Objects.isNull(entityR.getData())) {
            throw new CommonException(ResultCode.FAIL);
        }
        EmUserCompanyPersonalEntity companyPersonalEntity = entityR.getData();
        BeanUtils.copyProperties(companyPersonalEntity, procInstanceEntity);
        procInstanceEntity.setProcApplyTime(new Date());
        procInstanceEntity.setProcessKey(processVo.getProcessKey());
        procInstanceEntity.setProcessName(processVo.getProcessName());
        procInstanceEntity.setProcessState("1");
        String data = JSON.toJSONString(processVo);
        procInstanceEntity.setProcData(data);
        boolean b = baseMapper.insert(procInstanceEntity) <= 0;
        if (b) {
            throw new CommonException(ResultCode.FAIL);
        }

        // 查询流程定义
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        ProcessDefinition processDefinition = processService.getProcessDefinition(processVo.getProcessKey(), companyId);

        // 开启流程
        Map<String, Object> vars = Maps.newHashMap();
        if("process_leave".equals(processVo.getProcessKey())) {
            //请假
            vars.put("days",processVo.getDuration());
        }
        // 流程定义的id,业务数据id,内置的参数 (一方)
        ProcessInstance processInstance = processService.getRuntimeService().startProcessInstanceById(processDefinition.getId(), procInstanceEntity.getProcessId(), vars);

        // 自动执行第一个节点
        // 获取待执行的任务节点 (多方)
        Task task = processService.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        // 执行
        processService.getTaskService().complete(task.getId());

        // 获取下一个节点数据,填充业务数据中当前待审批人

        // 获取下一个节点,
        Task next = processService.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        if(next != null) {
            List<Map<String, String>> users = findCurrUsers(next, companyPersonalEntity);
            String usernames = "", userIdS = "";
            for (Map<String, String> user : users) {
                usernames += user.get("username") + " ";
                userIdS += user.get("id");
            }
            procInstanceEntity.setProcCurrNodeUserId(userIdS);
            procInstanceEntity.setProcCurrNodeUserName(usernames);
        }

        ProcTaskInstanceEntity procTaskInstanceEntity = new ProcTaskInstanceEntity();
        procTaskInstanceEntity.setProcessId(procInstanceEntity.getProcessId());
        procTaskInstanceEntity.setHandleUserId(companyPersonalEntity.getUserId());
        procTaskInstanceEntity.setHandleUserName(companyPersonalEntity.getUsername());
        procTaskInstanceEntity.setHandleTime(new Date());
        procTaskInstanceEntity.setHandleType("2");
        procTaskInstanceEntity.setTaskKey(task.getTaskDefinitionKey());
        procTaskInstanceEntity.setTaskName(task.getName());
        procTaskInstanceEntity.setHandleOpinion("发起申请");

        if (procTaskInstanceDao.insert(procTaskInstanceEntity) <= 0 && baseMapper.updateById(procInstanceEntity) <= 0) {
            throw new CommonException(ResultCode.FAIL);
        }
        return true;
    }

    /**
     * 提交审核
     * @param taskInstance 任务实例
     * @return
     * @throws CommonException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean commit(ProcTaskInstanceEntity taskInstance) throws CommonException {
        //1.查询业务流程对象
        String processId = taskInstance.getProcessId();
        ProcInstanceEntity instance = baseMapper.selectById(processId);
        //2.设置业务流程状态
        instance.setProcessState(taskInstance.getHandleType());
        //3.根据不同的操作类型,完成不同的业务处理
        //查询出activiti中的流程实例 (根据自己的业务id查询activiti中的流程实例)
        ProcessInstance processInstance = processService.getRuntimeService().createProcessInstanceQuery().processInstanceBusinessKey(processId).singleResult();
        R<EmUserCompanyPersonalEntity> entityR = employeeApi.info(taskInstance.getHandleUserId());
        if (entityR.getCode() != ResultCode.SUCCESS.code() || Objects.isNull(entityR.getData())) {
            throw new CommonException(ResultCode.FAIL);
        }
        EmUserCompanyPersonalEntity companyPersonalEntity = entityR.getData();
        if ("2".equals(taskInstance.getHandleType())) {
            //3.1 如果审核通过,完成当前的任务
            //查询出当前节点,并完成当前节点任务
            Task task = processService.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
            processService.getTaskService().complete(task.getId());
            //查询出下一个任务节点,如果存在下一个流程没有结束
            Task next = processService.getTaskService().createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
            if (next != null) {
                List<Map<String, String>> users = findCurrUsers(next, companyPersonalEntity);
                String usernames = "", userIdS = "";
                for (Map<String, String> user : users) {
                    usernames += user.get("username") + " ";
                    userIdS += user.get("id");
                }
                instance.setProcCurrNodeUserId(userIdS);
                instance.setProcCurrNodeUserName(usernames);
                instance.setProcessState("1");
            } else {
                //如果不存在下一个节点,任务结束
                instance.setProcessState("2");
            }

        } else {
            //3.2 如果审核不通过,或者撤销(删除activiti流程)
            processService.getRuntimeService().deleteProcessInstance(processInstance.getId(), taskInstance.getHandleOpinion());
        }
        //4.更新业务流程对象,保存业务任务对象
        if (baseMapper.updateById(instance) <= 0) {
            throw new CommonException(ResultCode.FAIL);
        }
        taskInstance.setHandleUserName(companyPersonalEntity.getUsername());
        taskInstance.setHandleTime(new Date());

        if ( procTaskInstanceDao.insert(taskInstance) <= 0) {
            throw new CommonException(ResultCode.FAIL);
        }

        return true;
    }

    private List<Map<String, String>> findCurrUsers(Task nextTask, EmUserCompanyPersonalEntity  emUserCompanyPersonal) {

        Map<String, Object> emUserCompanyPersonalToMap = BeanMapUtils.beanToMap(emUserCompanyPersonal);

        //查询任务的节点数据(候选人组)
        List<IdentityLink> IdentityLinks = processService.getTaskService().getIdentityLinksForTask(nextTask.getId());
        List<EmUserCompanyPersonalEntity> users = new ArrayList<>();

        //候选人组id
        List<String> groupIds = IdentityLinks.stream().map(IdentityLink::getGroupId).collect(Collectors.toList());
        //查询userGroup
        List<Map<String, Object>> groupMaps = procUserGroupDao.selectMaps(Wrappers.<ProcUserGroupEntity>lambdaQuery().in(ProcUserGroupEntity::getId, groupIds));
        List<String> sqlStrs = groupMaps.stream().map(item -> {
            String param = (String) item.get("param");
            String paramValue = (String) emUserCompanyPersonalToMap.get(StringUtils.underlineToCamel(param));
            return ((String) item.get("isql")).replaceAll("\\$\\{" + param + "\\}", paramValue);
        }).collect(Collectors.toList());

        List<Map<String, String>> bsUserEntities = baseMapper.selectBsUsers(sqlStrs);

        return bsUserEntities;
    }
}