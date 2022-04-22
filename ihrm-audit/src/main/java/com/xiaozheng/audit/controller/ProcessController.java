package com.xiaozheng.audit.controller;

import com.xiaozheng.audit.service.ProcessService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.vo.proc.ProcessDefinitionVo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.interceptor.CommandContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * What -- 工作流-流程控制
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.audit.controller
 * @ClassName: ProcessController
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/16 13:31
 */
@RestController
@RequestMapping("act/process")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    /**
     * 部署新流程
     *     前端将绘制好的流程模型图(bpmn)文件上传到方法中
     *     参数 : 上传的文件
     *          MultipartFile
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="processKey",value="流程Key",dataType = "MultipartFile", paramType = "query")
    })
    @PostMapping("/deploy")
    @ApiOperation("部署新流程")
    public R deploy(@RequestParam("file") MultipartFile file) throws IOException {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        processService.deployProcess(file, companyId);
        return R.ok();
    }

    /**
     * 查询所有的流程定义
     */
    @GetMapping(value = "/definition")
    @ApiOperation("查询所有的流程定义")
    public R<List<ProcessDefinitionVo>> definitionList() throws IOException {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        List<ProcessDefinitionVo> list = processService.getProcessDefinitionList(companyId);
        CommandContext commandContext = Context.getCommandContext();
        return R.ok(ResultCode.SUCCESS.code(),ResultCode.SUCCESS.message()).data(list);
    }

    /**
     * 设置流程的挂起与激活状态
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="processKey",value="流程Key",dataType = "String", paramType = "path",example="process_leave")
    })
    @GetMapping(value = "/suspend/{processKey}")
    @ApiOperation("设置流程的挂起与激活状态")
    public R suspendProcess(@PathVariable String processKey) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        int process = processService.suspendProcess(processKey, companyId);
        return process != 0 ? process == 1 ? R.ok("状态激活"): R.ok("状态挂起") : R.fail("激活或挂起失败");
    }

}
