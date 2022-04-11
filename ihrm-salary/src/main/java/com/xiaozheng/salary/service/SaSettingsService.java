package com.xiaozheng.salary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.sa.SaSettingsEntity;

import java.util.Map;

/**
 * 工资-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
public interface SaSettingsService extends IService<SaSettingsEntity> {

    PageUtils<SaSettingsEntity> queryPage(SaSettingsEntity saSettings, Map<String, Object> params);
}

