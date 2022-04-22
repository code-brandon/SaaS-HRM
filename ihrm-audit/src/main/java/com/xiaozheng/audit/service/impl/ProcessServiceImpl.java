package com.xiaozheng.audit.service.impl;


import com.xiaozheng.audit.service.ProcessService;
import com.xiaozheng.model.vo.proc.ProcessDefinitionVo;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.audit.service.impl
 * @ClassName: ProcessServiceImpl
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/16 13:38
 */
@Service("processService")
public class ProcessServiceImpl implements ProcessService {

    /**
     * 流程定义和部署存储库操作服务
     */
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 运行时服务
     */
    @Autowired
    private RuntimeService runtimeService;

    /**
     * 任务服务
     */
    @Autowired
    private TaskService taskService;

    /**
     * 流程部署
     *
     * @param file      上传的bpmn文件
     * @param companyId 企业ID
     */
    @Override
    public void deployProcess(MultipartFile file, String companyId) throws IOException {
        // 获取文件名
        final String fileName = file.getOriginalFilename();
        // 开始创建新部署
        DeploymentBuilder deploymentBuilder =  repositoryService.createDeployment();
        // 添加流程文件
        deploymentBuilder.addBytes(fileName, file.getBytes()).tenantId(companyId);
        Deployment deploy = deploymentBuilder.deploy();
        System.out.println(deploy);
    }

    /**
     * 查询所有的流程定义
     *
     * @param companyId 企业ID
     * @return
     */
    @Override
    public List<ProcessDefinitionVo> getProcessDefinitionList(String companyId) {
        return repositoryService.createProcessDefinitionQuery().processDefinitionTenantId(companyId)
                .latestVersion().list().stream().map(item -> {
                    // TODO 解决 Context.getCommandContext() 为空 引起的报错
                    ProcessDefinitionVo processDefinitionVo = new ProcessDefinitionVo();
                    BeanUtils.copyProperties(item, processDefinitionVo);
                    return processDefinitionVo;
                }).collect(Collectors.toList());
    }

    /**
     * 设置流程的挂起与激活状态
     *  @param processKey 流程ID
     * @param companyId 企业ID
     * @return
     */
    @Override
    public int suspendProcess(String processKey, String companyId) {
        //1.根据processKey查询流程定义
        ProcessDefinition definition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processKey)
                .processDefinitionTenantId(companyId).latestVersion().singleResult();
        int flag = 0;
        //2.判断是否为挂起状态
        if(definition.isSuspended()) {
            //2.1 如果是挂起状态:设置为激活
            repositoryService.activateProcessDefinitionById(definition.getId());
            flag = 1;
        }else {
            //2.2 如果不是激活状态: 设置为挂起
            repositoryService.suspendProcessDefinitionById(definition.getId());
            flag = 2;
        }
        return flag;
    }

    @Override
    public ProcessDefinition getProcessDefinition(String processKey, String companyId) {
        return repositoryService.createProcessDefinitionQuery()
                .processDefinitionKey(processKey)
                .processDefinitionTenantId(companyId)
                .latestVersion().singleResult();
    }

    @Override
    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    @Override
    public TaskService getTaskService() {
        return taskService;
    }
}
