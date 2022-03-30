package com.xiaozheng.socialsecurity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.socialsecurity.dao.SsArchiveDetailDao;
import com.xiaozheng.socialsecurity.service.SsArchiveDetailService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-归档详情实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssArchiveDetailService")
public class SsArchiveDetailServiceImpl extends ServiceImpl<SsArchiveDetailDao, SsArchiveDetailEntity> implements SsArchiveDetailService {

    @Override
    public PageUtils<SsArchiveDetailEntity> queryPage(SsArchiveDetailEntity ssArchiveDetail,Map<String, Object> params) {
        IPage<SsArchiveDetailEntity> page = this.page(
                new Query<SsArchiveDetailEntity>().getPage(params),
                Wrappers.query(ssArchiveDetail)
        );
        return new PageUtils(page);
    }

}