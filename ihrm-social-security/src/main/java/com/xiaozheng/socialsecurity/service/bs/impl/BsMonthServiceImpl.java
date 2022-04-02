package com.xiaozheng.socialsecurity.service.bs.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.bs.BsMonthEntity;
import com.xiaozheng.socialsecurity.dao.bs.BsMonthDao;
import com.xiaozheng.socialsecurity.service.bs.BsMonthService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * bs_月份实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@Service("bsMonthService")
public class BsMonthServiceImpl extends ServiceImpl<BsMonthDao, BsMonthEntity> implements BsMonthService {

    @Override
    public PageUtils<BsMonthEntity> queryPage(BsMonthEntity bsMonth, Map<String, Object> params) {
        IPage<BsMonthEntity> page = this.page(
                new Query<BsMonthEntity>().getPage(params),
                Wrappers.query(bsMonth)
        );
        return new PageUtils(page);
    }

}