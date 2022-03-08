package com.xiaozheng.company.controller.co;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.company.service.co.CoCompanyService;
import com.xiaozheng.model.co.CoCompanyEntity;
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
 * @date 2022-02-08 13:48:37
 */
@Api(tags = "公司")
@RestController
@RequestMapping("co/company")
public class CoCompanyController {
    @Autowired
    private CoCompanyService coCompanyService;

    /**
     * 分页查询所有数据
     *
     * @param params 请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页显示记录数", dataType = "String", paramType = "query", example = "10")
    })
    @ApiOperation("分页查询所有数据")
    @GetMapping("/page")
    public R<Map<String, PageUtils<CoCompanyEntity>>> page(@RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<CoCompanyEntity> page = coCompanyService.page(params);
        return R.ok("查询成功").data("page", page);
    }

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
    public R<Map<String, PageUtils<CoCompanyEntity>>> queryPage(@RequestBody @ApiParam(name = "公司", value = " 公司实体对象", required = true) CoCompanyEntity coCompany, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<CoCompanyEntity> page = coCompanyService.queryPage(coCompany, params);
        return R.ok("查询成功").data("page", page);
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
    public R<CoCompanyEntity> info(@PathVariable("id") String id) {
        CoCompanyEntity coCompany = coCompanyService.getById(id);

        return Objects.nonNull(coCompany) ? R.ok("查询成功").data(coCompany) : R.error("查询失败");
    }

    /**
     * 保存数据
     *
     * @param coCompany 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R save(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) CoCompanyEntity coCompany) {

        return coCompanyService.save(coCompany) ? R.ok("保存成功") : R.error("保存失败");
    }

    /**
     * 修改数据
     *
     * @param coCompany 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R update(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) CoCompanyEntity coCompany) {

        return coCompanyService.updateById(coCompany) ? R.ok("修改成功") : R.error("修改失败");
    }

    /**
     * 删除数据
     *
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] ids) {

        return coCompanyService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}