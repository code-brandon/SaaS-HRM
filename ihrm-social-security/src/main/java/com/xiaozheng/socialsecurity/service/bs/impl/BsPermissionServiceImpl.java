package com.xiaozheng.socialsecurity.service.bs.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.bs.BsPermissionEntity;
import com.xiaozheng.socialsecurity.dao.bs.BsPermissionDao;
import com.xiaozheng.socialsecurity.service.bs.BsPermissionService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * bs_许可实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@Service("bsPermissionService")
public class BsPermissionServiceImpl extends ServiceImpl<BsPermissionDao, BsPermissionEntity> implements BsPermissionService {

    @Override
    public PageUtils<BsPermissionEntity> queryPage(BsPermissionEntity bsPermission, Map<String, Object> params) {
        IPage<BsPermissionEntity> page = this.page(
                new Query<BsPermissionEntity>().getPage(params),
                Wrappers.query(bsPermission)
        );
        return new PageUtils(page);
    }

}