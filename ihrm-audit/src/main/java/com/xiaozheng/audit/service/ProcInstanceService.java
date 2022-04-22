package com.xiaozheng.audit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.proc.ProcInstanceEntity;
import com.xiaozheng.model.proc.ProcTaskInstanceEntity;
import com.xiaozheng.model.vo.proc.ProcessVo;

import java.util.Map;

/**
 * 流程 拓展表  -- 业务流程实例表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
public interface ProcInstanceService extends IService<ProcInstanceEntity> {

    /**
     * 查询申请列表
     *  参数:
     *      page,size
     *  业务参数:
     *      审批类型
     *      审批状态(多个,每个状态之间使用","隔开)
     *      当前节点的待处理人
     * @param params  请求集合
     * @return 所有数据
     */
    PageUtils<ProcInstanceEntity> queryPage(ProcInstanceEntity procInstance, Map<String, Object> params);

    /**
     * 流程申请
     * @param processVo 实体对象
     * @return 新增结果
     */
    boolean saveProcess(ProcessVo processVo) throws CommonException;


    /**
     * 提交审核
     *      handleType; // 处理类型（2审批通过；3审批不通过；4撤销）
     */
    boolean commit(ProcTaskInstanceEntity taskInstance) throws CommonException;
}

