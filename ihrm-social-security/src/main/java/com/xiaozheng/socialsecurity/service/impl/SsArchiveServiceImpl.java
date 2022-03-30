package com.xiaozheng.socialsecurity.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.ss.SsArchiveEntity;
import com.xiaozheng.socialsecurity.dao.SsArchiveDao;
import com.xiaozheng.socialsecurity.service.SsArchiveService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 社保-归档表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssArchiveService")
public class SsArchiveServiceImpl extends ServiceImpl<SsArchiveDao, SsArchiveEntity> implements SsArchiveService {

    @Override
    public PageUtils<SsArchiveEntity> queryPage(SsArchiveEntity ssArchive,Map<String, Object> params) {
        IPage<SsArchiveEntity> page = this.page(
                new Query<SsArchiveEntity>().getPage(params),
                Wrappers.query(ssArchive)
        );
        return new PageUtils(page);
    }

}