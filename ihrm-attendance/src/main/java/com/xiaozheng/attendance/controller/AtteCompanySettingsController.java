package com.xiaozheng.attendance.controller;

import com.xiaozheng.attendance.service.AtteCompanySettingsService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteCompanySettingsEntity;
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
 * 考勤-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Api(tags = "考勤-企业设置信息")
@RestController
@RequestMapping("attendance/attecompanysettings")
public class AtteCompanySettingsController {
    @Autowired
    private AtteCompanySettingsService atteCompanySettingsService;

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
    public R<Map<String, PageUtils<AtteCompanySettingsEntity>>> queryPage(@RequestBody @ApiParam(name="考勤-企业设置信息",value="考勤-企业设置信息 实体对象",required=true) AtteCompanySettingsEntity atteCompanySettings, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<AtteCompanySettingsEntity> page = atteCompanySettingsService.queryPage(atteCompanySettings,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<BsCityEntity>> queryList(){
        List<AtteCompanySettingsEntity> atteCompanySettingss = atteCompanySettingsService.list();
        return R.ok("查询成功").data("list",atteCompanySettingss);
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
    public R<AtteCompanySettingsEntity> info(@PathVariable("companyId") String companyId){
            AtteCompanySettingsEntity atteCompanySettings = atteCompanySettingsService.getById(companyId);

        return Objects.nonNull(atteCompanySettings) ? R.ok("查询成功").data(atteCompanySettings) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param atteCompanySettings 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="考勤-企业设置信息",value="考勤-企业设置信息 实体对象",required=true) AtteCompanySettingsEntity atteCompanySettings){

        return atteCompanySettingsService.save(atteCompanySettings) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param atteCompanySettings 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="考勤-企业设置信息",value="考勤-企业设置信息 实体对象",required=true) AtteCompanySettingsEntity atteCompanySettings){

        return atteCompanySettingsService.updateById(atteCompanySettings) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param companyIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] companyIds){

        return atteCompanySettingsService.removeByIds(Arrays.asList(companyIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
