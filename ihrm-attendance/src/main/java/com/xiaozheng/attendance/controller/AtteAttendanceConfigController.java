package com.xiaozheng.attendance.controller;

import com.xiaozheng.attendance.service.AtteAttendanceConfigService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteAttendanceConfigEntity;
import com.xiaozheng.model.bs.BsCityEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 考勤配置表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Api(tags = "考勤配置表")
@RestController
@RequestMapping("atte/attendanceconfig")
public class AtteAttendanceConfigController {
    @Autowired
    private AtteAttendanceConfigService atteAttendanceConfigService;

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
    public R<Map<String, PageUtils<AtteAttendanceConfigEntity>>> queryPage(@RequestBody @ApiParam(name = "考勤配置表", value = "考勤配置表 实体对象", required = true) AtteAttendanceConfigEntity atteAttendanceConfig, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<AtteAttendanceConfigEntity> page = atteAttendanceConfigService.queryPage(atteAttendanceConfig, params);
        return R.ok("查询成功").data("page", page);
    }

    /**
     * 查询所有数据
     *
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<BsCityEntity>> queryList() {
        List<AtteAttendanceConfigEntity> atteAttendanceConfigs = atteAttendanceConfigService.list();
        return R.ok("查询成功").data("list", atteAttendanceConfigs);
    }


    /**
     * 通过部门ID和企业ID查询考勤配置
     *
     * @param departmentId 部门ID
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "部门ID", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过部门ID和企业ID查询考勤配置")
    @GetMapping("/info/{departmentId}")
    public R<AtteAttendanceConfigEntity> info(@PathVariable("departmentId") String departmentId) {

        AtteAttendanceConfigEntity atteAttendanceConfig = atteAttendanceConfigService.getByDeptIdAndcompanyId(departmentId);

        return Objects.nonNull(atteAttendanceConfig) ? R.ok("考勤配置查询成功").data(atteAttendanceConfig) : R.fail("没有考勤配置！").data(atteAttendanceConfig);
    }

    /**
     * 保存数据
     *
     * @param atteAttendanceConfig 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "考勤配置表", value = "考勤配置表 实体对象", required = true) AtteAttendanceConfigEntity atteAttendanceConfig) {

        return atteAttendanceConfigService.save(atteAttendanceConfig) ? R.ok("保存成功").data(true) : R.fail("保存失败").data(false);
    }

    /**
     * 保存或修改企业考勤设置
     *
     * @param atteAttendanceConfig 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/updateOrSave")
    public R<Boolean> update(@RequestBody @ApiParam(name = "考勤配置表", value = "考勤配置表 实体对象", required = true) AtteAttendanceConfigEntity atteAttendanceConfig) {

        return atteAttendanceConfigService.updateOrSave(atteAttendanceConfig) ? R.ok("修改成功").data(true) : R.fail("修改失败").data(false);
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

        return atteAttendanceConfigService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.fail("删除失败").data(false);
    }

}
