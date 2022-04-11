package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaSettingsDao;
import com.xiaozheng.model.sa.SaSettingsEntity;
import com.xiaozheng.salary.service.SaSettingsService;

/**
 * 工资-企业设置信息实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Service("saSettingsService")
public class SaSettingsServiceImpl extends ServiceImpl<SaSettingsDao, SaSettingsEntity> implements SaSettingsService {

    @Override
    public PageUtils<SaSettingsEntity> queryPage(SaSettingsEntity saSettings,Map<String, Object> params) {
        IPage<SaSettingsEntity> page = this.page(
                new Query<SaSettingsEntity>().getPage(params),
                Wrappers.query(saSettings)
        );
        return new PageUtils(page);
    }

}