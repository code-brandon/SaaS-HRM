package com.xiaozheng.audit.controller;

import com.xiaozheng.audit.service.ProcInstanceService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.proc.ProcInstanceEntity;
import com.xiaozheng.model.proc.ProcTaskInstanceEntity;
import com.xiaozheng.model.vo.proc.ProcessVo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 流程 拓展表  -- 业务流程实例表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Api(tags = "流程 拓展表  -- 业务流程实例表")
@RestController
@RequestMapping("audit/procinstance")
public class ProcInstanceController {
    @Autowired
    private ProcInstanceService procInstanceService;

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
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码",dataType = "String", paramType = "query",example="1"),
            @ApiImplicitParam(name="limit",value="每页显示记录数",dataType = "String", paramType = "query",example="10")
    })
    @ApiOperation("查询申请列表")
    @PostMapping("/queryPage")
    public R<Map<String, PageUtils<ProcInstanceEntity>>> queryPage(@RequestBody @ApiParam(name="流程 拓展表  -- 业务流程实例表",value="流程 拓展表  -- 业务流程实例表 实体对象",required=true) ProcInstanceEntity procInstance, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<ProcInstanceEntity> page = procInstanceService.queryPage(procInstance,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<ProcInstanceEntity>> queryList(){
        List<ProcInstanceEntity> procInstances = procInstanceService.list();
        return R.ok("查询成功").data("list",procInstances);
    }


    /**
     * 查询申请的详情数据
     * @param processId 申请对象的id
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="processId",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("查询申请的详情数据")
    @GetMapping("/info/{processId}")
    public R<ProcInstanceEntity> info(@PathVariable("processId") String processId){
            ProcInstanceEntity procInstance = procInstanceService.getById(processId);

        return Objects.nonNull(procInstance) ? R.ok("查询成功").data(procInstance) : R.error("查询失败");
    }


    /**
     * 流程申请
     * @param processVo 实体对象
     * @return 新增结果
     */
    @ApiOperation("流程申请")
    @PostMapping("/saveProcess")
    public R<Boolean> saveProcess(@RequestBody @ApiParam(name="流程 拓展表  -- 业务流程实例表",value="流程 拓展表  -- 业务流程实例表 实体对象",required=true) ProcessVo processVo) throws CommonException {

        return procInstanceService.saveProcess(processVo) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 提交审核
     *      handleType; // 处理类型（2审批通过；3审批不通过；4撤销）
     */
    @ApiOperation("提交审核")
    @PutMapping(value = "/commit")
    public R commit(@RequestBody @ApiParam(name="流程 拓展表  -- 业务流程的任务表",value="流程 拓展表  -- 业务流程的任务表 实体对象",required=true) ProcTaskInstanceEntity taskInstance) throws IOException, CommonException {
        //调用service
        boolean b = procInstanceService.commit(taskInstance);
        return R.ok();
    }

    /**
     * 修改数据
     * @param procInstance 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="流程 拓展表  -- 业务流程实例表",value="流程 拓展表  -- 业务流程实例表 实体对象",required=true) ProcInstanceEntity procInstance){

        return procInstanceService.updateById(procInstance) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param processIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] processIds){

        return procInstanceService.removeByIds(Arrays.asList(processIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
