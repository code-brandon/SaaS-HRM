package com.xiaozheng.socialsecurity.controller.ss;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.ss.SsCompanySettingsEntity;
import com.xiaozheng.socialsecurity.service.ss.SsCompanySettingsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 * 社保-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Api(tags = "社保-企业设置信息")
@RestController
@RequestMapping("ss/companysettings")
public class SsCompanySettingsController {
    @Autowired
    private SsCompanySettingsService ssCompanySettingsService;

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
    public R<Map<String, PageUtils<SsCompanySettingsEntity>>> queryPage(@RequestBody @ApiParam(name = "社保-企业设置信息", value = "社保-企业设置信息 实体对象", required = true) SsCompanySettingsEntity ssCompanySettings, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<SsCompanySettingsEntity> page = ssCompanySettingsService.queryPage(ssCompanySettings, params);
        return R.ok("查询成功").data("page", page);
    }


    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info")
    public R<SsCompanySettingsEntity> info() {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        SsCompanySettingsEntity ssCompanySettings = ssCompanySettingsService.getById(companyId);
        return Objects.nonNull(ssCompanySettings) ? R.ok("查询成功").data(ssCompanySettings) : R.error("查询失败");
    }

    /**
     * 保存数据
     *
     * @param ssCompanySettings 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "社保-企业设置信息", value = "社保-企业设置信息 实体对象", required = true) SsCompanySettingsEntity ssCompanySettings) {
        // 完成当月设置：1
        ssCompanySettings.setIsSettings(1);
        ssCompanySettings.setCompanyId(ShiroContextUtils.getProfile().getCompanyId());
        return ssCompanySettingsService.save(ssCompanySettings) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param ssCompanySettings 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "社保-企业设置信息", value = "社保-企业设置信息 实体对象", required = true) SsCompanySettingsEntity ssCompanySettings) {
        ssCompanySettings.setCompanyId(ShiroContextUtils.getProfile().getCompanyId());
        return ssCompanySettingsService.updateById(ssCompanySettings) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     *
     * @param companyIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] companyIds) {

        return ssCompanySettingsService.removeByIds(Arrays.asList(companyIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
