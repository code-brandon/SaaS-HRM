package com.xiaozheng.company.controller;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.company.service.CoDepartmentService;
import com.xiaozheng.model.co.CoDepartmentEntity;
import com.xiaozheng.model.dto.DepartmentListDto;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;


/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@Api(tags = "")
@RestController
@RequestMapping("co/department")
public class CoDepartmentController {
    @Autowired
    private CoDepartmentService coDepartmentService;

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
    public R<Map<String, PageUtils<CoDepartmentEntity>>> page(@RequestParam Map<String, Object> params) {
        PageUtils<CoDepartmentEntity> page = coDepartmentService.page(params);
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
    public R<Map<String, PageUtils<CoDepartmentEntity>>> queryPage(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) CoDepartmentEntity coDepartment, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<CoDepartmentEntity> page = coDepartmentService.queryPage(coDepartment, params);
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
    public R<CoDepartmentEntity> info(@PathVariable("id") String id) {
        CoDepartmentEntity coDepartment = coDepartmentService.getById(id);

        return Objects.nonNull(coDepartment) ? R.ok("查询成功").data(coDepartment) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 通过企业ID查询部门列表
     *
     * @param departmentId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "departmentId", value = "企业ID", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过企业ID查询部门列表")
    @GetMapping("/departments/{departmentId}")
    public R<CoDepartmentEntity> departmentList(@PathVariable("departmentId") String departmentId) {
        DepartmentListDto departmentList = coDepartmentService.getDepartmentList(departmentId);

        return R.ok("查询成功").data(departmentList);
    }

    /**
     * 保存数据
     *
     * @param coDepartment 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) CoDepartmentEntity coDepartment) {

        return coDepartmentService.save(coDepartment) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param coDepartment 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) CoDepartmentEntity coDepartment) {

        return coDepartmentService.updateById(coDepartment) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
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

        return coDepartmentService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }


        /**
         * 根据companyId和departmentCode获取部门信息
         * 参数为空查询所有
         * @param companyId
         * @param departmentCode
         * @return
         */
        @ApiOperation("根据companyId和departmentCode获取部门信息")
        @PostMapping(value = "/CompanyIdAndDepartmentCode")
        public R<List<CoDepartmentEntity>> querByCompanyIdAndDepartmentCode(@RequestParam("companyId") String companyId,@RequestParam(value = "departmentCode",required = false) String departmentCode) {
        List<CoDepartmentEntity> coDepartments = coDepartmentService.querByCompanyIdAndDepartmentCode(companyId, departmentCode);
        return !CollectionUtils.isEmpty(coDepartments) ? R.ok("查询成功").data(coDepartments) : R.error(ResultCode.FAIL.code(),"查询失败");
    }
}
