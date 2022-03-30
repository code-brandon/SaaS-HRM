package com.xiaozheng.socialsecurity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsPaymentItemEntity;
import com.xiaozheng.socialsecurity.dao.SsPaymentItemDao;
import com.xiaozheng.socialsecurity.service.SsPaymentItemService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-缴费项目实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssPaymentItemService")
public class SsPaymentItemServiceImpl extends ServiceImpl<SsPaymentItemDao, SsPaymentItemEntity> implements SsPaymentItemService {

    @Override
    public PageUtils<SsPaymentItemEntity> queryPage(SsPaymentItemEntity ssPaymentItem,Map<String, Object> params) {
        IPage<SsPaymentItemEntity> page = this.page(
                new Query<SsPaymentItemEntity>().getPage(params),
                Wrappers.query(ssPaymentItem)
        );
        return new PageUtils(page);
    }

}