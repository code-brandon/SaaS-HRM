package com.xiaozheng.system.service.pe;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.PeUserDto;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PeUserService extends IService<PeUserEntity> {

    PageUtils<PeUserEntity> queryPage(PeUserEntity peUser, Map<String, Object> params);

    /**
     * 通过主键查询单条数据和所关联角色
     * @param id
     * @return
     */
    PeUserEntity infoAndRoleById(String id);

    /**
     * 通过手机号查询用户详情
     * @param mobile
     * @return
     */
    PeUserDto profileByMobile(String mobile);

    /**
     * 根据Mobile 查询用户
     * @param mobile
     * @return
     */
    PeUserEntity queryByMobile(String mobile);

    /**
     * 用户登录
     * @param usetVo
     * @return
     */
    String login(PeUsetVo usetVo);

    /**
     * 获取个人信息
     * @param userId
     * @return
     */
    PeUserDto profile(String userId) throws Exception;

    /**
     * 保存用户数据
     *
     * @param peUser 实体对象
     * @return 新增结果
     */
    boolean saveAndEncrypt(PeUserEntity peUser);
}

