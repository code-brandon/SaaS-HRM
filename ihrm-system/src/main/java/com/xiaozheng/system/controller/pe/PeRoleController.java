package com.xiaozheng.system.controller.pe;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.PeRoleDto;
import com.xiaozheng.model.pe.PeRoleEntity;
import com.xiaozheng.system.service.pe.PeRoleService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Api(tags = "")
@RestController
@RequestMapping("pe/role")
public class PeRoleController {
    @Autowired
    private PeRoleService peRoleService;

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
    public R<Map<String, PageUtils<PeRoleEntity>>> queryPage(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeRoleEntity peRole, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<PeRoleEntity> page = peRoleService.queryPage(peRole, params);
        return R.ok("查询成功").data("page", page);
    }

    /**
     * 查询所有数据
     * @return
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/queryList")
    public R<List<PeRoleEntity>> queryList() {
        List<PeRoleEntity> roles = peRoleService.list();
        return R.ok("查询成功").data("roles", roles);
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{id}")
    public R<PeRoleEntity> info(@PathVariable("id") String id) {
        PeRoleEntity peRole = peRoleService.getById(id);

        return Objects.nonNull(peRole) ? R.ok("查询成功").data(peRole) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 通过主键查询单条数据和所关联权限
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据和所关联角色")
    @GetMapping("/infoAndPerm/{id}")
    public R<PeRoleDto> infoAndPerm(@PathVariable("id") String id) {
        PeRoleDto peRoleDto = peRoleService.infoAndPermById(id);

        return Objects.nonNull(peRoleDto) ? R.ok("查询成功").data(peRoleDto) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 保存数据
     *
     * @param peRole 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeRoleEntity peRole) {

        return peRoleService.save(peRole) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param peRole 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeRoleEntity peRole) {

        return peRoleService.updateById(peRole) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     *
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] ids) {

        return peRoleService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

}
