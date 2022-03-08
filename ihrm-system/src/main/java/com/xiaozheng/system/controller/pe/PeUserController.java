package com.xiaozheng.system.controller.pe;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.JwtUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.system.service.pe.PeUserService;
import com.xiaozheng.model.dto.PeUserDto;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import io.jsonwebtoken.Claims;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
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

    @Autowired
    private JwtUtils jwtUtils;

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

        return Objects.nonNull(peUser) ? R.ok("查询成功").data(peUser) : R.error("查询失败");
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
        return Objects.nonNull(peUserEntity) ? R.ok("查询成功").data(peUserEntity) : R.error("查询失败");
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

        return peUserService.save(peUser) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
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

        return peUserService.updateById(peUser) ? R.ok("修改成功").data(true) : R.error("修改失败").data(false);
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

        return peUserService.removeByIds(Arrays.asList(ids)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
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
        return  !StringUtils.isEmpty(token) ? R.ok("登录成功").data(token) : R.error("登录失败").data(token);
    }

    /**
     *获取个人信息
     * @return
     */
    @ApiOperation("获取个人信息")
    @GetMapping("/profile")
    public R<PeUserDto> profile(HttpServletRequest request) throws Exception {
        /**
         * 从请求头中获取token
         */
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization)) {
            throw new CommonException(ResultCode.UNAUTHENTICATED);
        }
        String token = authorization.replace("Bearer ", "");

        System.out.println("token = " + token);

        Claims claims = jwtUtils.parseJwt(token);


        PeUserDto peUserDto = peUserService.profile(claims.getId());
        return Objects.nonNull(peUserDto) ? R.ok("查询成功").data(peUserDto) : R.error("查询失败");
    }

}
