package com.xiaozheng.audit.service;

import com.xiaozheng.model.vo.proc.ProcessDefinitionVo;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.company.service
 * @ClassName: ProcessService
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/16 13:37
 */
public interface ProcessService {

    /**
     * 流程部署
     * @param file 上传的bpmn文件
     * @param companyId 企业ID
     */
    void deployProcess(MultipartFile file, String companyId) throws IOException;

    /**
     * 查询所有的流程定义
     * @param companyId 流程ID
     * @return
     */
    List<ProcessDefinitionVo> getProcessDefinitionList(String companyId);

    /**
     * 设置流程的挂起与激活状态
     * @param processKey 流程ID
     * @param companyId 企业ID
     * @return
     */
    int suspendProcess(String processKey, String companyId);

    /**
     * 获取流程定义
     *
     * @param processKey key
     * @param companyId  企业ID
     * @return
     */
    ProcessDefinition getProcessDefinition(String processKey, String companyId);

    RuntimeService getRuntimeService();

    TaskService getTaskService();
}
