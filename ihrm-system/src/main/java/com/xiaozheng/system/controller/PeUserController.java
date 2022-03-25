package com.xiaozheng.system.controller;

import com.google.common.collect.Maps;
import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.common.entity.PeUserDto;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import com.xiaozheng.system.service.PeUserService;
import io.swagger.annotations.*;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Api(tags = "")
@RestController
@RequestMapping("pe/user")
public class PeUserController {

    @Autowired
    private PeUserService peUserService;

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
    public R<Map<String, PageUtils<PeUserEntity>>> queryPage(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserEntity peUser, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<PeUserEntity> page = peUserService.queryPage(peUser, params);
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
    public R<PeUserEntity> info(@PathVariable("id") String id) {
        PeUserEntity peUser = peUserService.getById(id);

        return Objects.nonNull(peUser) ? R.ok("查询成功").data(peUser) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("获取当前登录用户的id和姓名")
    @GetMapping("/simple")
    public R<Map> simple() {
        PeUserDto peUserDto = ShiroContextUtils.getProfile();
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        hashMap.put("id", peUserDto.getId());
        hashMap.put("username", peUserDto.getUsername());
        return Objects.nonNull(peUserDto) ? R.ok("查询成功").data(hashMap) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 通过主键查询单条数据和所关联角色
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据和所关联角色")
    @GetMapping("/infoAndRole/{id}")
    public R<PeUserEntity> infoAndRole(@PathVariable("id") String id) {
        PeUserEntity peUserEntity = peUserService.infoAndRoleById(id);
        return Objects.nonNull(peUserEntity) ? R.ok("查询成功").data(peUserEntity) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * 通过mobile查询单条数据
     *
     * @param mobile 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/profileByMobile/{mobile}")
    public Object profileByMobile(@PathVariable("mobile") String mobile,@RequestHeader(value = "x-Device", required = true) String al) throws CommonException {
        if (!"xiaozheng".equalsIgnoreCase(al)) {
            throw new CommonException(ResultCode.UNAUTHENTICATED);
        }
        return peUserService.profileByMobile(mobile);
    }

    /**
     * 保存数据
     *
     * @param peUser 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存数据")
    @PostMapping("/save")
    public R<Boolean> save(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserEntity peUser) {
        return peUserService.saveAndEncrypt(peUser) ? R.ok("保存成功").data(true) : R.error(ResultCode.FAIL.code(),"保存失败").data(false);
    }

    /**
     * 修改数据
     *
     * @param peUser 实体对象
     * @return 修改结果
     */
    @ApiOperation("修改数据")
    @PutMapping("/update")
    public R<Boolean> update(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUserEntity peUser) {

        return peUserService.updateById(peUser) ? R.ok("修改成功").data(true) : R.error(ResultCode.FAIL.code(),"修改失败").data(false);
    }

    /**
     * 删除数据
     *
     * @param ids 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @RequiresPermissions(value = "API-USER-DELETE")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] ids) {

        return peUserService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error(ResultCode.FAIL.code(),"删除失败").data(false);
    }

    /**
     * 用户登录
     *
     * @param usetVo 实体对象
     * @return 新增结果
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public R<String> login(@RequestBody @ApiParam(name = "", value = " 实体对象", required = true) PeUsetVo usetVo) {
        String token = peUserService.login(usetVo);
        return  !StringUtils.isEmpty(token) ? R.ok("登录成功").data(token) : R.error(ResultCode.FAIL.code(),"登录失败").data(token);
    }

    /**
     *获取个人信息
     * @return
     */
    @ApiOperation("获取个人信息")
    @GetMapping("/profile")
    public R<PeUserDto> profile() {
        PeUserDto peUserDto = ShiroContextUtils.getProfile();
        return Objects.nonNull(peUserDto) ? R.ok("查询成功").data(peUserDto) : R.error(ResultCode.FAIL.code(),"查询失败");
    }

    /**
     * Excel导入员工
     * @param file
     * @return
     */
    @ApiOperation("Excel导入员工")
    @PostMapping("/import")
    public R<Boolean> importUser(@RequestParam("file") MultipartFile file) throws IOException, CommonException {

        return peUserService.parseExcelToSaveEmployees(file) ? R.ok("导入成功").data(true) : R.error(ResultCode.FAIL.code(),"导入失败").data(false);
    }

    /**
     * 用户头像上传
     * @param file
     * @param id
     * @return
     */
    @ApiOperation("用户头像上传")
    @PostMapping("/upload/{id}")
    public R<String> uploadUserAvatar(@RequestParam("file") MultipartFile file, @PathVariable String id) {
        String userAvatar = peUserService.uploadUserAvatar(file, id);
        return !StringUtils.isEmpty(userAvatar) ? R.ok("上传成功").data(userAvatar) : R.error(ResultCode.FAIL.code(),"导入失败").data(userAvatar);
    }

}
