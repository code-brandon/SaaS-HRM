package com.xiaozheng.system.controller.pe;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.pe.PeUserRoleEntity;
import com.xiaozheng.model.vo.pe.PeUserRoleOrRolePermissionVo;
import com.xiaozheng.system.service.pe.PeUserRoleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Api(tags = "")
@RestController
@RequestMapping("pe/userrole")
public class PeUserRoleController {
    @Autowired
    private PeUserRoleService peUserRoleService;

    /**
     * 分页条件查询所有数据
     *
     * @param params 请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页显示记录数", dataType = "String", paramType = "query", example = "10")
    })
    @ApiOperation("分页条件查询所有数据")
    @PostMapping("/queryPage")
    public R<Map<String, PageUtils<PeUserRoleEntity>>> queryPage(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserRoleEntity peUserRole, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<PeUserRoleEntity> page = peUserRoleService.queryPage(peUserRole, params);
        return R.ok("查询成功").data("page", page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param roleId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "roleId", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{roleId}")
    public R<PeUserRoleEntity> info(@PathVariable("roleId") String roleId) {
        PeUserRoleEntity peUserRole = peUserRoleService.getById(roleId);

        return Objects.nonNull(peUserRole) ? R.ok("查询成功").data(peUserRole) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 保存数据
     *
     * @param peUserRole 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserRoleEntity peUserRole) {

        return peUserRoleService.save(peUserRole) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param peUserRole 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserRoleEntity peUserRole) {

        return peUserRoleService.updateById(peUserRole) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     *
     * @param roleIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] roleIds) {

        return peUserRoleService.removeByIds(Arrays.asList(roleIds)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

    /**
     * 用户分配角色
     * @param peUserRoleVo
     * @return
     */
    @ApiOperation("用户分配角色")
    @PutMapping("/assignRoles")
    public R<Boolean> assignRoles(@RequestBody @ApiParam(name = "peUserRoleVo", value = "实体对象", required = true) PeUserRoleOrRolePermissionVo peUserRoleVo) throws Exception {

        return peUserRoleService.assignRoles(peUserRoleVo) ? R.ok("分配成功").data(true) : R.error(ResultCode.FAIL.code(),"分配失败").data(false);
    }

}
