package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaArchiveDao;
import com.xiaozheng.model.sa.SaArchiveEntity;
import com.xiaozheng.salary.service.SaArchiveService;

/**
 * 工资-归档表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:51
 */
@Service("saArchiveService")
public class SaArchiveServiceImpl extends ServiceImpl<SaArchiveDao, SaArchiveEntity> implements SaArchiveService {

    @Override
    public PageUtils<SaArchiveEntity> queryPage(SaArchiveEntity saArchive,Map<String, Object> params) {
        IPage<SaArchiveEntity> page = this.page(
                new Query<SaArchiveEntity>().getPage(params),
                Wrappers.query(saArchive)
        );
        return new PageUtils(page);
    }

}