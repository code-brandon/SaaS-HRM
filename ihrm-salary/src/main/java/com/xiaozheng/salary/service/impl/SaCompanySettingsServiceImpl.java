package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaCompanySettingsDao;
import com.xiaozheng.model.sa.SaCompanySettingsEntity;
import com.xiaozheng.salary.service.SaCompanySettingsService;

/**
 * 工资-企业设置信息实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Service("saCompanySettingsService")
public class SaCompanySettingsServiceImpl extends ServiceImpl<SaCompanySettingsDao, SaCompanySettingsEntity> implements SaCompanySettingsService {

    @Override
    public PageUtils<SaCompanySettingsEntity> queryPage(SaCompanySettingsEntity saCompanySettings,Map<String, Object> params) {
        IPage<SaCompanySettingsEntity> page = this.page(
                new Query<SaCompanySettingsEntity>().getPage(params),
                Wrappers.query(saCompanySettings)
        );
        return new PageUtils(page);
    }

}