package com.xiaozheng.socialsecurity.controller;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsArchiveEntity;
import com.xiaozheng.socialsecurity.service.SsArchiveService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 * 社保-归档表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Api(tags = "社保-归档表")
@RestController
@RequestMapping("ss/archive")
public class SsArchiveController {
    @Autowired
    private SsArchiveService ssArchiveService;

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
    public R<Map<String, PageUtils<SsArchiveEntity>>> queryPage(@RequestBody @ApiParam(name="社保-归档表",value="社保-归档表 实体对象",required=true) SsArchiveEntity ssArchive, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<SsArchiveEntity> page = ssArchiveService.queryPage(ssArchive,params);
        return R.ok("查询成功").data("page",page);
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
    public R<SsArchiveEntity> info(@PathVariable("id") String id){
            SsArchiveEntity ssArchive = ssArchiveService.getById(id);

        return Objects.nonNull(ssArchive) ? R.ok("查询成功").data(ssArchive) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param ssArchive 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="社保-归档表",value="社保-归档表 实体对象",required=true) SsArchiveEntity ssArchive){

        return ssArchiveService.save(ssArchive) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param ssArchive 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="社保-归档表",value="社保-归档表 实体对象",required=true) SsArchiveEntity ssArchive){

        return ssArchiveService.updateById(ssArchive) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] ids){

        return ssArchiveService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
