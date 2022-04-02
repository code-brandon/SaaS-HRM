package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsCityPaymentItemEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsCityPaymentItemDao;
import com.xiaozheng.socialsecurity.service.ss.SsCityPaymentItemService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-城市与缴费项目关联表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssCityPaymentItemService")
public class SsCityPaymentItemServiceImpl extends ServiceImpl<SsCityPaymentItemDao, SsCityPaymentItemEntity> implements SsCityPaymentItemService {

    @Override
    public PageUtils<SsCityPaymentItemEntity> queryPage(SsCityPaymentItemEntity ssCityPaymentItem, Map<String, Object> params) {
        IPage<SsCityPaymentItemEntity> page = this.page(
                new Query<SsCityPaymentItemEntity>().getPage(params),
                Wrappers.query(ssCityPaymentItem)
        );
        return new PageUtils(page);
    }

}