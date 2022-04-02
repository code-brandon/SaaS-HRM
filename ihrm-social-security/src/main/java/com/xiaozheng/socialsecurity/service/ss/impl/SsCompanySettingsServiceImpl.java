package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsCompanySettingsEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsCompanySettingsDao;
import com.xiaozheng.socialsecurity.service.ss.SsCompanySettingsService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-企业设置信息实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssCompanySettingsService")
public class SsCompanySettingsServiceImpl extends ServiceImpl<SsCompanySettingsDao, SsCompanySettingsEntity> implements SsCompanySettingsService {

    @Override
    public PageUtils<SsCompanySettingsEntity> queryPage(SsCompanySettingsEntity ssCompanySettings, Map<String, Object> params) {
        IPage<SsCompanySettingsEntity> page = this.page(
                new Query<SsCompanySettingsEntity>().getPage(params),
                Wrappers.query(ssCompanySettings)
        );
        return new PageUtils(page);
    }

}