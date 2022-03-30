package com.xiaozheng.socialsecurity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import com.xiaozheng.socialsecurity.dao.SsUserSocialSecurityDao;
import com.xiaozheng.socialsecurity.service.SsUserSocialSecurityService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-用户社保信息表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssUserSocialSecurityService")
public class SsUserSocialSecurityServiceImpl extends ServiceImpl<SsUserSocialSecurityDao, SsUserSocialSecurityEntity> implements SsUserSocialSecurityService {

    @Override
    public PageUtils<SsUserSocialSecurityEntity> queryPage(SsUserSocialSecurityEntity ssUserSocialSecurity,Map<String, Object> params) {
        IPage<SsUserSocialSecurityEntity> page = this.page(
                new Query<SsUserSocialSecurityEntity>().getPage(params),
                Wrappers.query(ssUserSocialSecurity)
        );
        return new PageUtils(page);
    }

}