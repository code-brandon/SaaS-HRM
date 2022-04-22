package com.xiaozheng.audit.controller;

import com.xiaozheng.audit.service.ProcUserGroupService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.proc.ProcUserGroupEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 流程 拓展表 -- 业务流程的用户组表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Api(tags = "流程 拓展表 -- 业务流程的用户组表")
@RestController
@RequestMapping("audit/procusergroup")
public class ProcUserGroupController {
    @Autowired
    private ProcUserGroupService procUserGroupService;

    /**
     * 分页条件查询所有数据
     * @param params  请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码",dataType = "String", paramType = "query",example="1"),
            @ApiImplicitParam(name="limit",value="每页显示记录数",dataType = "String", paramType = "query",example="10")
    })
    @ApiOperation("分页条件查询所有数据")
    @PostMapping("/queryPage")
    public R<Map<String, PageUtils<ProcUserGroupEntity>>> queryPage(@RequestBody @ApiParam(name="流程 拓展表 -- 业务流程的用户组表",value="流程 拓展表 -- 业务流程的用户组表 实体对象",required=true) ProcUserGroupEntity procUserGroup, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<ProcUserGroupEntity> page = procUserGroupService.queryPage(procUserGroup,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<ProcUserGroupEntity>> queryList(){
        List<ProcUserGroupEntity> procUserGroups = procUserGroupService.list();
        return R.ok("查询成功").data("list",procUserGroups);
    }


    /**
     * 通过主键查询单条数据
     * @param id 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{id}")
    public R<ProcUserGroupEntity> info(@PathVariable("id") String id){
            ProcUserGroupEntity procUserGroup = procUserGroupService.getById(id);

        return Objects.nonNull(procUserGroup) ? R.ok("查询成功").data(procUserGroup) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param procUserGroup 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="流程 拓展表 -- 业务流程的用户组表",value="流程 拓展表 -- 业务流程的用户组表 实体对象",required=true) ProcUserGroupEntity procUserGroup){

        return procUserGroupService.save(procUserGroup) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param procUserGroup 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="流程 拓展表 -- 业务流程的用户组表",value="流程 拓展表 -- 业务流程的用户组表 实体对象",required=true) ProcUserGroupEntity procUserGroup){

        return procUserGroupService.updateById(procUserGroup) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] ids){

        return procUserGroupService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
