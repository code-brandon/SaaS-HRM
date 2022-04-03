package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteCompanySettingsEntity;

import java.util.Map;

/**
 * 考勤-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteCompanySettingsService extends IService<AtteCompanySettingsEntity> {

    PageUtils<AtteCompanySettingsEntity> queryPage(AtteCompanySettingsEntity atteCompanySettings, Map<String, Object> params);
}

