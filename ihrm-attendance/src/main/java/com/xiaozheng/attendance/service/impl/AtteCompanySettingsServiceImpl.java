package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteCompanySettingsDao;
import com.xiaozheng.attendance.service.AtteCompanySettingsService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteCompanySettingsEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤-企业设置信息实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteCompanySettingsService")
public class AtteCompanySettingsServiceImpl extends ServiceImpl<AtteCompanySettingsDao, AtteCompanySettingsEntity> implements AtteCompanySettingsService {

    @Override
    public PageUtils<AtteCompanySettingsEntity> queryPage(AtteCompanySettingsEntity atteCompanySettings,Map<String, Object> params) {
        IPage<AtteCompanySettingsEntity> page = this.page(
                new Query<AtteCompanySettingsEntity>().getPage(params),
                Wrappers.query(atteCompanySettings)
        );
        return new PageUtils(page);
    }

}