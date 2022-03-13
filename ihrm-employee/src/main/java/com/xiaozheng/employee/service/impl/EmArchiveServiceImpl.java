package com.xiaozheng.employee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.employee.dao.EmArchiveDao;
import com.xiaozheng.employee.service.EmArchiveService;
import com.xiaozheng.model.em.EmArchiveEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emArchiveService")
public class EmArchiveServiceImpl extends ServiceImpl<EmArchiveDao, EmArchiveEntity> implements EmArchiveService {

    @Override
    public PageUtils<EmArchiveEntity> queryPage(EmArchiveEntity emArchive,Map<String, Object> params) {
        IPage<EmArchiveEntity> page = this.page(
                new Query<EmArchiveEntity>().getPage(params),
                Wrappers.query(emArchive)
        );
        return new PageUtils(page);
    }

}