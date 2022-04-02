package com.xiaozheng.socialsecurity.controller.ss;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.socialsecurity.service.ss.SsArchiveDetailService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 * 社保-归档详情
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Api(tags = "社保-归档详情")
@RestController
@RequestMapping("ss/archivedetail")
public class SsArchiveDetailController {
    @Autowired
    private SsArchiveDetailService ssArchiveDetailService;

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
    public R<Map<String, PageUtils<SsArchiveDetailEntity>>> queryPage(@RequestBody @ApiParam(name = "社保-归档详情", value = "社保-归档详情 实体对象", required = true) SsArchiveDetailEntity ssArchiveDetail, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<SsArchiveDetailEntity> page = ssArchiveDetailService.queryPage(ssArchiveDetail, params);
        return R.ok("查询成功").data("page", page);
    }

    /**
     * 分页条件查询用户所在企业所有翻译数据
     *
     * @param params 请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页显示记录数", dataType = "String", paramType = "query", example = "10")
    })
    @ApiOperation("分页条件查询用户所在企业所有翻译数据")
    @PostMapping("/queryPageAndTran")
    public R<Map<String, PageUtils<SsArchiveDetailEntity>>> queryPageAndTran(@RequestBody @ApiParam(name = "社保-归档详情", value = "社保-归档详情 实体对象", required = true) SsArchiveDetailEntity ssArchiveDetail, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<SsArchiveDetailEntity> page = ssArchiveDetailService.queryPageAndTran(ssArchiveDetail, params);
        return R.ok("查询成功").data("page", page);
    }

    /**
     * 根据年月获取统计存档详细信息
     *
     * @param yearsMonth
     * @return
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "yearsMonth", value = "年月", dataType = "String", paramType = "path", example = "202204")
    })
    @ApiOperation("获取统计存档详细信息")
    @PostMapping("/countArchiveDetail/{yearsMonth}")
    public R<Map<String, Object>> getCountArchiveDetail(@PathVariable("yearsMonth") String yearsMonth) {
        Map<String, Object> map = ssArchiveDetailService.getCountArchiveDetail(yearsMonth);
        return CollectionUtils.isNotEmpty(map) ? R.ok("查询成功").data(map) : R.error("查询失败");
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
    public R<SsArchiveDetailEntity> info(@PathVariable("id") String id) {
        SsArchiveDetailEntity ssArchiveDetail = ssArchiveDetailService.getById(id);

        return Objects.nonNull(ssArchiveDetail) ? R.ok("查询成功").data(ssArchiveDetail) : R.error("查询失败");
    }

    /**
     * 保存数据
     *
     * @param ssArchiveDetail 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "社保-归档详情", value = "社保-归档详情 实体对象", required = true) SsArchiveDetailEntity ssArchiveDetail) {

        return ssArchiveDetailService.save(ssArchiveDetail) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param ssArchiveDetail 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "社保-归档详情", value = "社保-归档详情 实体对象", required = true) SsArchiveDetailEntity ssArchiveDetail) {

        return ssArchiveDetailService.updateById(ssArchiveDetail) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
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

        return ssArchiveDetailService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
