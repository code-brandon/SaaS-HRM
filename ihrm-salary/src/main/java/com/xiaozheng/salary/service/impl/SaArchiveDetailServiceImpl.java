package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaArchiveDetailDao;
import com.xiaozheng.model.sa.SaArchiveDetailEntity;
import com.xiaozheng.salary.service.SaArchiveDetailService;

/**
 * 工资-归档详情实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Service("saArchiveDetailService")
public class SaArchiveDetailServiceImpl extends ServiceImpl<SaArchiveDetailDao, SaArchiveDetailEntity> implements SaArchiveDetailService {

    @Override
    public PageUtils<SaArchiveDetailEntity> queryPage(SaArchiveDetailEntity saArchiveDetail,Map<String, Object> params) {
        IPage<SaArchiveDetailEntity> page = this.page(
                new Query<SaArchiveDetailEntity>().getPage(params),
                Wrappers.query(saArchiveDetail)
        );
        return new PageUtils(page);
    }

}