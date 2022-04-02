package com.xiaozheng.socialsecurity.service.bs;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.bs.BsPermissionEntity;

import java.util.Map;

/**
 * bs_许可
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
public interface BsPermissionService extends IService<BsPermissionEntity> {

    PageUtils<BsPermissionEntity> queryPage(BsPermissionEntity bsPermission, Map<String, Object> params);
}

