package com.xiaozheng.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.pe.PePermissionMenuEntity;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PePermissionMenuService extends IService<PePermissionMenuEntity> {

    PageUtils<PePermissionMenuEntity> queryPage(PePermissionMenuEntity pePermissionMenu, Map<String, Object> params);
}

