package com.xiaozheng.salary.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;

import com.xiaozheng.model.sa.SaCompanySettingsEntity;
import com.xiaozheng.salary.service.SaCompanySettingsService;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 工资-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Api(tags = "工资-企业设置信息")
@RestController
@RequestMapping("salary/sacompanysettings")
public class SaCompanySettingsController {
    @Autowired
    private SaCompanySettingsService saCompanySettingsService;

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
    public R<Map<String, PageUtils<SaCompanySettingsEntity>>> queryPage(@RequestBody @ApiParam(name="工资-企业设置信息",value="工资-企业设置信息 实体对象",required=true) SaCompanySettingsEntity saCompanySettings,@RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<SaCompanySettingsEntity> page = saCompanySettingsService.queryPage(saCompanySettings,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<SaCompanySettingsEntity>> queryList(){
        List<SaCompanySettingsEntity> saCompanySettingss = saCompanySettingsService.list();
        return R.ok("查询成功").data("list",saCompanySettingss);
    }


    /**
     * 通过主键查询单条数据
     * @param companyId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="companyId",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{companyId}")
    public R<SaCompanySettingsEntity> info(@PathVariable("companyId") String companyId){
            SaCompanySettingsEntity saCompanySettings = saCompanySettingsService.getById(companyId);

        return Objects.nonNull(saCompanySettings) ? R.ok("查询成功").data(saCompanySettings) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param saCompanySettings 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="工资-企业设置信息",value="工资-企业设置信息 实体对象",required=true) SaCompanySettingsEntity saCompanySettings){

        return saCompanySettingsService.save(saCompanySettings) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param saCompanySettings 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="工资-企业设置信息",value="工资-企业设置信息 实体对象",required=true) SaCompanySettingsEntity saCompanySettings){

        return saCompanySettingsService.updateById(saCompanySettings) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param companyIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] companyIds){

        return saCompanySettingsService.removeByIds(Arrays.asList(companyIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
