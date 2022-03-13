package com.xiaozheng.employee.controller;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.employee.service.EmArchiveService;
import com.xiaozheng.model.em.EmArchiveEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;


/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Api(tags = "月度员工归档")
@RestController
@RequestMapping("em/archive")
public class EmArchiveController {
    @Autowired
    private EmArchiveService emArchiveService;

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
    public R<Map<String, PageUtils<EmArchiveEntity>>> queryPage(@RequestBody @ApiParam(name="月度员工归档表",value=" 实体对象",required=true) EmArchiveEntity emArchive, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<EmArchiveEntity> page = emArchiveService.queryPage(emArchive,params);
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
    public R<EmArchiveEntity> info(@PathVariable("id") String id){
            EmArchiveEntity emArchive = emArchiveService.getById(id);

        return Objects.nonNull(emArchive) ? R.ok("查询成功").data(emArchive) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 保存数据
     * @param emArchive 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="月度员工归档表",value=" 实体对象",required=true) EmArchiveEntity emArchive){

        return emArchiveService.save(emArchive) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     * @param emArchive 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="月度员工归档表",value=" 实体对象",required=true) EmArchiveEntity emArchive){

        return emArchiveService.updateById(emArchive) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] ids){

        return emArchiveService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

}
