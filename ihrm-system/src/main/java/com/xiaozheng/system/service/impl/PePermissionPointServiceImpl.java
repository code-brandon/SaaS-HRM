package com.xiaozheng.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.pe.PePermissionPointEntity;
import com.xiaozheng.system.dao.PePermissionPointDao;
import com.xiaozheng.system.service.PePermissionPointService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("pePermissionPointService")
public class PePermissionPointServiceImpl extends ServiceImpl<PePermissionPointDao, PePermissionPointEntity> implements PePermissionPointService {

    @Override
    public PageUtils<PePermissionPointEntity> queryPage(PePermissionPointEntity pePermissionPoint, Map<String, Object> params) {
        IPage<PePermissionPointEntity> page = this.page(
                new Query<PePermissionPointEntity>().getPage(params),
                Wrappers.query(pePermissionPoint)
        );
        return new PageUtils(page);
    }

}