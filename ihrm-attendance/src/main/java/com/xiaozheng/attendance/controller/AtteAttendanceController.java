package com.xiaozheng.attendance.controller;

import com.xiaozheng.attendance.service.AtteAttendanceService;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteAttendanceEntity;
import com.xiaozheng.model.bo.AtteAttendanceBo;
import com.xiaozheng.model.bs.BsCityEntity;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * 考勤表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Api(tags = "考勤表")
@RestController
@RequestMapping("atte/attendance")
public class AtteAttendanceController {
    @Autowired
    private AtteAttendanceService atteAttendanceService;

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
    public R<Map<String, PageUtils<AtteAttendanceEntity>>> queryPage(@RequestBody @ApiParam(name="考勤表",value="考勤表 实体对象",required=true) AtteAttendanceEntity atteAttendance, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<AtteAttendanceEntity> page = atteAttendanceService.queryPage(atteAttendance,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 分页条件查询用户考勤
     * @param params  请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="page",value="当前页码",dataType = "String", paramType = "query",example="1"),
            @ApiImplicitParam(name="limit",value="每页显示记录数",dataType = "String", paramType = "query",example="10")
    })
    @ApiOperation("分页条件查询用户考勤")
    @PostMapping("/queryAtte")
    public R<Map<String, PageUtils<AtteAttendanceBo>>> queryAtte(@RequestBody @ApiParam(name="考勤表",value="考勤表 实体对象",required=true) AtteAttendanceEntity atteAttendance, @RequestParam @ApiIgnore() Map<String, Object> params){
        PageUtils<AtteAttendanceBo> page = atteAttendanceService.queryAtte(atteAttendance,params);
        return R.ok("查询成功").data("page",page);
    }

    /**
     * 查询所有数据
     * @return 所有数据
     */
    @ApiOperation("查询所有数据")
    @GetMapping("/list")
    public R<List<BsCityEntity>> queryList(){
        List<AtteAttendanceEntity> atteAttendances = atteAttendanceService.list();
        return R.ok("查询成功").data("list",atteAttendances);
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
    public R<AtteAttendanceEntity> info(@PathVariable("id") String id){
            AtteAttendanceEntity atteAttendance = atteAttendanceService.getById(id);

        return Objects.nonNull(atteAttendance) ? R.ok("查询成功").data(atteAttendance) : R.error("查询失败");
    }

    /**
     * 保存数据
     * @param atteAttendance 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name="考勤表",value="考勤表 实体对象",required=true) AtteAttendanceEntity atteAttendance){

        return atteAttendanceService.save(atteAttendance) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 修改数据
     * @param atteAttendance 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name="考勤表",value="考勤表 实体对象",required=true) AtteAttendanceEntity atteAttendance){

        return atteAttendanceService.updateById(atteAttendance) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
    }

    /**
     * 删除数据
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name="ID",value="ID集合",required=true) String[] ids){

        return atteAttendanceService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

    /**
     * 考勤数据Excel上传
     * @param file
     * @return 是否成功
     */
    @PostMapping("/import")
    public R importExcel(@RequestParam(name = "file") MultipartFile file) throws Exception {
        boolean b = atteAttendanceService.importExcel(file);
        return R.ok();
    }

}
