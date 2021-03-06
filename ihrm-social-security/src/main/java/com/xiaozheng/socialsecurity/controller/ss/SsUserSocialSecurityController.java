package com.xiaozheng.socialsecurity.controller.ss;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import com.xiaozheng.socialsecurity.service.ss.SsUserSocialSecurityService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.Objects;


/**
 * 社保-用户社保信息表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Api(tags = "社保-用户社保信息表")
@RestController
@RequestMapping("ss/usersocialsecurity")
public class SsUserSocialSecurityController {
    @Autowired
    private SsUserSocialSecurityService ssUserSocialSecurityService;

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
    public R<Map<String, PageUtils<SsUserSocialSecurityEntity>>> queryPage(@RequestBody @ApiParam(name = "社保-用户社保信息表", value = "社保-用户社保信息表 实体对象", required = true) SsUserSocialSecurityEntity ssUserSocialSecurity, @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<SsUserSocialSecurityEntity> page = ssUserSocialSecurityService.queryPage(ssUserSocialSecurity, params);
        return R.ok("查询成功").data("page", page);
    }

    /**
     * 分页条件查询所有翻译数据,社保主界面列表
     *
     * @param params 请求集合
     * @return 所有数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "当前页码", dataType = "String", paramType = "query", example = "1"),
            @ApiImplicitParam(name = "limit", value = "每页显示记录数", dataType = "String", paramType = "query", example = "10")
    })
    @ApiOperation("分页条件查询所有翻译数据")
    @PostMapping("/queryPageAndTran")
    public R<Map<String, PageUtils<SsUserSocialSecurityDto>>> queryPageAndTran(@RequestBody @ApiParam(name = "社保-用户社保信息表", value = "社保-用户社保信息表 实体对象", required = true) SsUserSocialSecurityEntity ssUserSocialSecurity,
                                                                               @RequestParam @ApiIgnore() Map<String, Object> params) {
        PageUtils<SsUserSocialSecurityDto> page = ssUserSocialSecurityService.queryPageAndTran(ssUserSocialSecurity, params);
        return R.ok("查询成功").data("page", page);
    }


    /**
     * 通过主键查询单条翻译数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/infoAndTran/{userId}")
    public R<SsUserSocialSecurityDto> infoAndTran(@PathVariable("userId") String userId) {
        SsUserSocialSecurityDto ssUserSocialSecurity = ssUserSocialSecurityService.getByIdAndTran(userId);

        return Objects.nonNull(ssUserSocialSecurity) ? R.ok("查询成功").data(ssUserSocialSecurity) : R.error("查询失败");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "主键", dataType = "String", paramType = "path", example = "1")
    })
    @ApiOperation("通过主键查询单条数据")
    @GetMapping("/info/{userId}")
    public R<SsUserSocialSecurityEntity> info(@PathVariable("userId") String userId) {
        SsUserSocialSecurityEntity ssUserSocialSecurity = ssUserSocialSecurityService.getById(userId);

        return Objects.nonNull(ssUserSocialSecurity) ? R.ok("查询成功").data(ssUserSocialSecurity) : R.error("查询失败");
    }

    /**
     * 保存社保数据
     *
     * @param ssUserSocialSecurity 实体对象
     * @return 新增结果
     */
    @ApiOperation("保存或更新社保数据")
    @PutMapping("/saveOrUpdate")
    @Transactional(rollbackFor = Exception.class)
    public R<Boolean> saveOrUpdate(@RequestBody @ApiParam(name = "社保-用户社保信息表", value = "社保-用户社保信息表 实体对象", required = true) SsUserSocialSecurityEntity ssUserSocialSecurity) {
        ssUserSocialSecurity.setLastModifyTime(new Date());
        ssUserSocialSecurity.setSocialSecuritySwitchUpdateTime(new Date());
        ssUserSocialSecurity.setProvidentFundSwitchUpdateTime(new Date());
        return ssUserSocialSecurityService.saveOrUpdate(ssUserSocialSecurity) ? R.ok("保存成功").data(true) : R.error("保存失败").data(false);
    }

    /**
     * 删除数据
     *
     * @param userIds 集合/数组
     * @return 删除结果
     */
    @ApiOperation("删除数据")
    @DeleteMapping("/delete")
    public R<Boolean> delete(@RequestBody @ApiParam(name = "ID", value = "ID集合", required = true) String[] userIds) {

        return ssUserSocialSecurityService.removeByIds(Arrays.asList(userIds)) ? R.ok("删除成功").data(true) : R.error("删除失败").data(false);
    }

}
