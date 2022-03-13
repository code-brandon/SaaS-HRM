package com.xiaozheng.employee.controller;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.employee.service.EmUserCompanyPersonalService;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
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
@Api(tags = "员工详细信息")
@RestController
@RequestMapping("em/personal")
public class EmUserCompanyPersonalController {
    @Autowired
    private EmUserCompanyPersonalService emUserCompanyPersonalService;

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
    public R<Map<String, PageUtils<EmUserCompanyPersonalEntity>>> queryPage(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<EmUserCompanyPersonalEntity> page = emUserCompanyPersonalService.queryPage(emUserCompanyPersonal,params);
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
    public R<EmUserCompanyPersonalEntity> info(@PathVariable("userId") String userId){
            EmUserCompanyPersonalEntity emUserCompanyPersonal = emUserCompanyPersonalService.getById(userId);

        return Objects.nonNull(emUserCompanyPersonal) ? R.ok("查询成功").data(emUserCompanyPersonal) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 保存数据
     * @param emUserCompanyPersonal 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal){

        return emUserCompanyPersonalService.save(emUserCompanyPersonal) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     * @param emUserCompanyPersonal 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="员工详细信息表",value=" 实体对象",required=true) EmUserCompanyPersonalEntity emUserCompanyPersonal){

        return emUserCompanyPersonalService.updateById(emUserCompanyPersonal) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     * @param userIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] userIds){

        return emUserCompanyPersonalService.removeByIds(Arrays.asList(userIds)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

}
