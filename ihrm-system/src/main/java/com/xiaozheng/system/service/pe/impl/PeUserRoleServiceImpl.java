package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.system.dao.pe.PeUserRoleDao;
import com.xiaozheng.system.service.pe.PeUserRoleService;
import com.xiaozheng.model.pe.PeUserRoleEntity;
import com.xiaozheng.model.vo.pe.PeUserRoleOrRolePermissionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peUserRoleService")
public class PeUserRoleServiceImpl extends ServiceImpl<PeUserRoleDao, PeUserRoleEntity> implements PeUserRoleService {

    @Override
    public PageUtils<PeUserRoleEntity> queryPage(PeUserRoleEntity peUserRole, Map<String, Object> params) {
        IPage<PeUserRoleEntity> page = this.page(
                new Query<PeUserRoleEntity>().getPage(params),
                Wrappers.query(peUserRole)
        );
        return new PageUtils(page);
    }

    /**
     * 分配角色
     *
     * @param peUserRoleVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean assignRoles(PeUserRoleOrRolePermissionVo peUserRoleVo) throws Exception {

        String userId = peUserRoleVo.getUserId();
        List<PeUserRoleEntity> userRoles = peUserRoleVo.getRoleIds().stream().map(roleId -> {
            PeUserRoleEntity peUserRoleEntity = new PeUserRoleEntity();
            peUserRoleEntity.setUserId(userId);
            peUserRoleEntity.setRoleId(roleId);
            return peUserRoleEntity;
        }).collect(Collectors.toList());

        return this.saveBatch(userRoles);
    }

}