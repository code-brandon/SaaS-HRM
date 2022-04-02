package com.xiaozheng.socialsecurity.service.ss;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsPaymentItemEntity;

import java.util.Map;

/**
 * 社保-缴费项目
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsPaymentItemService extends IService<SsPaymentItemEntity> {

    PageUtils<SsPaymentItemEntity> queryPage(SsPaymentItemEntity ssPaymentItem, Map<String, Object> params);
}

