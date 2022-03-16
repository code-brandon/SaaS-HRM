package com.xiaozheng.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.pe.PePermissionMenuEntity;
import com.xiaozheng.system.dao.PePermissionMenuDao;
import com.xiaozheng.system.service.PePermissionMenuService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("pePermissionMenuService")
public class PePermissionMenuServiceImpl extends ServiceImpl<PePermissionMenuDao, PePermissionMenuEntity> implements PePermissionMenuService {

    @Override
    public PageUtils<PePermissionMenuEntity> queryPage(PePermissionMenuEntity pePermissionMenu, Map<String, Object> params) {
        IPage<PePermissionMenuEntity> page = this.page(
                new Query<PePermissionMenuEntity>().getPage(params),
                Wrappers.query(pePermissionMenu)
        );
        return new PageUtils(page);
    }

}