package com.xiaozheng.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.pe.PeUserRoleEntity;
import com.xiaozheng.model.vo.pe.PeUserRoleOrRolePermissionVo;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PeUserRoleService extends IService<PeUserRoleEntity> {

    PageUtils<PeUserRoleEntity> queryPage(PeUserRoleEntity peUserRole, Map<String, Object> params);

    /**
     * 分配角色
     * @param peUserRoleVo
     * @return
     */
    boolean assignRoles(PeUserRoleOrRolePermissionVo peUserRoleVo) throws Exception;
}

