package com.xiaozheng.attendance.controller;

import com.xiaozheng.attendance.service.AtteArchiveMonthlyInfoService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteArchiveMonthlyInfoEntity;
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
 * 考勤归档信息详情表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Api(tags = "考勤归档信息详情表")
@RestController
@RequestMapping("atte/archivemonthlyinfo")
public class AtteArchiveMonthlyInfoController {
    @Autowired
    private AtteArchiveMonthlyInfoService atteArchiveMonthlyInfoService;

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
    public R<Map<String, PageUtils<AtteArchiveMonthlyInfoEntity>>> queryPage(@RequestBody @ApiParam(name="考勤归档信息详情表",value="考勤归档信息详情表 实体对象",required=true) AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<AtteArchiveMonthlyInfoEntity> page = atteArchiveMonthlyInfoService.queryPage(atteArchiveMonthlyInfo,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<BsCityEntity>> queryList(){
        List<AtteArchiveMonthlyInfoEntity> atteArchiveMonthlyInfos = atteArchiveMonthlyInfoService.list();
        return R.ok("查询成功").data("list",atteArchiveMonthlyInfos);
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
    public R<AtteArchiveMonthlyInfoEntity> info(@PathVariable("id") String id){
            AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo = atteArchiveMonthlyInfoService.getById(id);

        return Objects.nonNull(atteArchiveMonthlyInfo) ? R.ok("查询成功").data(atteArchiveMonthlyInfo) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param atteArchiveMonthlyInfo 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="考勤归档信息详情表",value="考勤归档信息详情表 实体对象",required=true) AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo){

        return atteArchiveMonthlyInfoService.save(atteArchiveMonthlyInfo) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param atteArchiveMonthlyInfo 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="考勤归档信息详情表",value="考勤归档信息详情表 实体对象",required=true) AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo){

        return atteArchiveMonthlyInfoService.updateById(atteArchiveMonthlyInfo) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] ids){

        return atteArchiveMonthlyInfoService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

    /**
     * 获取月报数据
     * /attendances/archive/item?archiveDate=201907
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页显示记录数", dataType = "String", paramType = "query", example = "10")
    })
    @ApiOperation("获取月报数据")
    @PostMapping("/queryPageAndDate")
    public R<Map<String, PageUtils<AtteArchiveMonthlyInfoEntity>>> queryPageAndDate(@RequestBody @ApiParam(name = "考勤-归档详情", value = "考勤-归档详情 实体对象", required = true)  AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo, @RequestParam @ApiIgnore() Map<String,
            Object> params) {
        PageUtils<AtteArchiveMonthlyInfoEntity> page = atteArchiveMonthlyInfoService.queryPageAndDate(atteArchiveMonthlyInfo, params);
        return R.ok("查询成功").data("page", page);
    }

}
