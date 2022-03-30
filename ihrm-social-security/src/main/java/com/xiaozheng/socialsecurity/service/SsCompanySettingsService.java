package com.xiaozheng.socialsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsCompanySettingsEntity;

import java.util.Map;

/**
 * 社保-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsCompanySettingsService extends IService<SsCompanySettingsEntity> {

    PageUtils<SsCompanySettingsEntity> queryPage(SsCompanySettingsEntity ssCompanySettings, Map<String, Object> params);
}

