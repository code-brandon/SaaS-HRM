package com.xiaozheng.socialsecurity.service.ss;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;

import java.util.Map;

/**
 * 社保-用户社保信息表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsUserSocialSecurityService extends IService<SsUserSocialSecurityEntity> {

    PageUtils<SsUserSocialSecurityEntity> queryPage(SsUserSocialSecurityEntity ssUserSocialSecurity, Map<String, Object> params);

    /**
     * 分页条件查询所有翻译数据
     *
     * @param params 请求集合
     * @return 所有数据
     */
    PageUtils<SsUserSocialSecurityDto> queryPageAndTran(SsUserSocialSecurityEntity ssUserSocialSecurity, Map<String, Object> params);

    /**
     * 通过主键查询单条翻译数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    SsUserSocialSecurityDto getByIdAndTran(String userId);
}

