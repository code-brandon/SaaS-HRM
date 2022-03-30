package com.xiaozheng.socialsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsCityPaymentItemEntity;

import java.util.Map;

/**
 * 社保-城市与缴费项目关联表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsCityPaymentItemService extends IService<SsCityPaymentItemEntity> {

    PageUtils<SsCityPaymentItemEntity> queryPage(SsCityPaymentItemEntity ssCityPaymentItem, Map<String, Object> params);
}

