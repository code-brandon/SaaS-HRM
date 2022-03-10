package com.xiaozheng.employee.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xiaozheng.model.em.EmTransferpositionEntity;
import com.xiaozheng.employee.service.EmTransferpositionService;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Api(tags = "员工调岗申请")
@RestController
@RequestMapping("emp/transferposition")
public class EmTransferpositionController {
    @Autowired
    private EmTransferpositionService emTransferpositionService;

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
    public R<Map<String, PageUtils<EmTransferpositionEntity>>> queryPage(@RequestBody @ApiParam(name="员工调岗申请表",value=" 实体对象",required=true) EmTransferpositionEntity emTransferposition,
                                                                         @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<EmTransferpositionEntity> page = emTransferpositionService.queryPage(emTransferposition,params);
        return R.ok("查询成功").data("page",page);
    }


    /**
     * 通过主键查询单条数据
     * @param userId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="userId",value="主键",dataType = "String", paramType = "path",example="1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{userId}")
    public R<EmTransferpositionEntity> info(@PathVariable("userId") String userId){
            EmTransferpositionEntity emTransferposition = emTransferpositionService.getById(userId);

        return Objects.nonNull(emTransferposition) ? R.ok("查询成功").data(emTransferposition) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param emTransferposition 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="员工调岗申请表",value=" 实体对象",required=true) EmTransferpositionEntity emTransferposition){

        return emTransferpositionService.save(emTransferposition) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param emTransferposition 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="员工调岗申请表",value=" 实体对象",required=true) EmTransferpositionEntity emTransferposition){

        return emTransferpositionService.updateById(emTransferposition) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param userIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] userIds){

        return emTransferpositionService.removeByIds(Arrays.asList(userIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
