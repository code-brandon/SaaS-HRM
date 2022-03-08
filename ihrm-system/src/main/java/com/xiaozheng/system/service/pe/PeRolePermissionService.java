package com.xiaozheng.system.service.pe;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.pe.PeRolePermissionEntity;
import com.xiaozheng.model.vo.pe.PeUserRoleOrRolePermissionVo;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PeRolePermissionService extends IService<PeRolePermissionEntity> {

    PageUtils<PeRolePermissionEntity> queryPage(PeRolePermissionEntity peRolePermission, Map<String, Object> params);

    /**
     * 角色分配权限
     * @param peRolePermissionVo
     * @return
     */
    boolean assignPrem(PeUserRoleOrRolePermissionVo peRolePermissionVo) throws Exception;
}

