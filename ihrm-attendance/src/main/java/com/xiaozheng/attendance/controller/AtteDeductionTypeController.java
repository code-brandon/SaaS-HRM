package com.xiaozheng.attendance.controller;

import com.xiaozheng.attendance.service.AtteDeductionTypeService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteDeductionTypeEntity;
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
 * 扣款类型表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Api(tags = "扣款类型表")
@RestController
@RequestMapping("atte/deductiontype")
public class AtteDeductionTypeController {
    @Autowired
    private AtteDeductionTypeService atteDeductionTypeService;

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
    public R<Map<String, PageUtils<AtteDeductionTypeEntity>>> queryPage(@RequestBody @ApiParam(name="扣款类型表",value="扣款类型表 实体对象",required=true) AtteDeductionTypeEntity atteDeductionType, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<AtteDeductionTypeEntity> page = atteDeductionTypeService.queryPage(atteDeductionType,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<BsCityEntity>> queryList(){
        List<AtteDeductionTypeEntity> atteDeductionTypes = atteDeductionTypeService.list();
        return R.ok("查询成功").data("list",atteDeductionTypes);
    }


    /**
     * 通过主键查询单条数据
     * @param code 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="code",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{code}")
    public R<AtteDeductionTypeEntity> info(@PathVariable("code") String code){
            AtteDeductionTypeEntity atteDeductionType = atteDeductionTypeService.getById(code);

        return Objects.nonNull(atteDeductionType) ? R.ok("查询成功").data(atteDeductionType) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param atteDeductionType 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="扣款类型表",value="扣款类型表 实体对象",required=true) AtteDeductionTypeEntity atteDeductionType){

        return atteDeductionTypeService.save(atteDeductionType) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param atteDeductionType 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="扣款类型表",value="扣款类型表 实体对象",required=true) AtteDeductionTypeEntity atteDeductionType){

        return atteDeductionTypeService.updateById(atteDeductionType) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param codes 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] codes){

        return atteDeductionTypeService.removeByIds(Arrays.asList(codes)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
