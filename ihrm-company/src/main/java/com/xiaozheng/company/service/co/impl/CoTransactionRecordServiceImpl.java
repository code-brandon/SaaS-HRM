package com.xiaozheng.company.service.co.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.company.dao.co.CoTransactionRecordDao;
import com.xiaozheng.company.service.co.CoTransactionRecordService;
import com.xiaozheng.model.co.CoTransactionRecordEntity;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("coTransactionRecordService")
public class CoTransactionRecordServiceImpl extends ServiceImpl<CoTransactionRecordDao, CoTransactionRecordEntity> implements CoTransactionRecordService {

    @Override
    public PageUtils<CoTransactionRecordEntity> page(Map<String, Object> params) {
        IPage<CoTransactionRecordEntity> page = this.page(
                new Query<CoTransactionRecordEntity>().getPage(params),
                new QueryWrapper<CoTransactionRecordEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils<CoTransactionRecordEntity> queryPage(CoTransactionRecordEntity coTransactionRecord, Map<String, Object> params) {
        IPage<CoTransactionRecordEntity> page = this.page(
                new Query<CoTransactionRecordEntity>().getPage(params),
                Wrappers.query(coTransactionRecord)
        );
        return new PageUtils(page);
    }

}