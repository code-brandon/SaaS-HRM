package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.pe.PePermissionApiEntity;
import com.xiaozheng.system.dao.pe.PePermissionApiDao;
import com.xiaozheng.system.service.pe.PePermissionApiService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("pePermissionApiService")
public class PePermissionApiServiceImpl extends ServiceImpl<PePermissionApiDao, PePermissionApiEntity> implements PePermissionApiService {

    @Override
    public PageUtils<PePermissionApiEntity> queryPage(PePermissionApiEntity pePermissionApi, Map<String, Object> params) {
        IPage<PePermissionApiEntity> page = this.page(
                new Query<PePermissionApiEntity>().getPage(params),
                Wrappers.query(pePermissionApi)
        );
        return new PageUtils(page);
    }

}