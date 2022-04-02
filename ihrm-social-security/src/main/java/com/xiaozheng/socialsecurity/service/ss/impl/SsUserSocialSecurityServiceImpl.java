package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsUserSocialSecurityDao;
import com.xiaozheng.socialsecurity.service.ss.SsUserSocialSecurityService;
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
    public PageUtils<SsUserSocialSecurityEntity> queryPage(SsUserSocialSecurityEntity ssUserSocialSecurity, Map<String, Object> params) {
        IPage<SsUserSocialSecurityEntity> page = this.page(
                new Query<SsUserSocialSecurityEntity>().getPage(params),
                Wrappers.query(ssUserSocialSecurity)
        );
        return new PageUtils(page);
    }

    /**
     * 分页条件查询所有翻译数据
     *
     * @param ssUserSocialSecurity
     * @param params               请求集合
     * @return 所有数据
     */
    @Override
    public PageUtils<SsUserSocialSecurityDto> queryPageAndTran(SsUserSocialSecurityEntity ssUserSocialSecurity, Map<String, Object> params) {
        return new PageUtils(baseMapper.pageAndTran(
                new Query<SsUserSocialSecurityEntity>().getPage(params),
                ssUserSocialSecurity,
                ShiroContextUtils.getProfile().getCompanyId()
        ));
    }

    /**
     * 通过主键查询单条翻译数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    @Override
    public SsUserSocialSecurityDto getByIdAndTran(String userId) {
        return baseMapper.getByIdAndTran(userId);
    }

}