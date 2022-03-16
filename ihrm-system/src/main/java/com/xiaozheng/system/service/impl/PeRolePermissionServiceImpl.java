package com.xiaozheng.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.PermissionConstants;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.pe.PePermissionEntity;
import com.xiaozheng.model.pe.PeRolePermissionEntity;
import com.xiaozheng.model.vo.pe.PeUserRoleOrRolePermissionVo;
import com.xiaozheng.system.dao.PePermissionDao;
import com.xiaozheng.system.dao.PeRolePermissionDao;
import com.xiaozheng.system.service.PeRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peRolePermissionService")
public class PeRolePermissionServiceImpl extends ServiceImpl<PeRolePermissionDao, PeRolePermissionEntity> implements PeRolePermissionService {

    @Autowired
    private PePermissionDao permissionDao;

    @Override
    public PageUtils<PeRolePermissionEntity> queryPage(PeRolePermissionEntity peRolePermission, Map<String, Object> params) {
        IPage<PeRolePermissionEntity> page = this.page(
                new Query<PeRolePermissionEntity>().getPage(params),
                Wrappers.query(peRolePermission)
        );
        return new PageUtils(page);
    }

    /**
     * 角色分配权限
     *
     * @param peRolePermissionVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = CommonException.class)
    public boolean assignPrem(PeUserRoleOrRolePermissionVo peRolePermissionVo) throws Exception{
        String roleId = peRolePermissionVo.getRoleId();
        Set<String> permIds = peRolePermissionVo.getPermIds();
        // 获取Api类型的权限ID
        List<PePermissionEntity> pePermissions = permissionDao.queryByTypeAndPid(PermissionConstants.PERMISSION_API,permIds);
        List<String> strings = pePermissions.stream().map(PePermissionEntity::getId).collect(Collectors.toList());
        // Api类型权限ID和菜单与按钮ID聚合在一起
        permIds.addAll(strings);

        baseMapper.deleteById(roleId);

        Set<PeRolePermissionEntity> entitySet = permIds.stream().map(permId -> {
            PeRolePermissionEntity peRolePermissionEntity = new PeRolePermissionEntity();
            peRolePermissionEntity.setRoleId(roleId);
            peRolePermissionEntity.setPermissionId(permId);
            return peRolePermissionEntity;
        }).collect(Collectors.toSet());


        /*// 循环添加到数据库
        for (String permId : permIds) {
            PeRolePermissionEntity peRolePermissionEntity = new PeRolePermissionEntity();
            peRolePermissionEntity.setRoleId(roleId);
            peRolePermissionEntity.setPermissionId(permId);
            boolean b = false;
            try {

            } catch (Exception e) {
                if (e.getMessage().contains("Duplicate entry")) {
                    // 删除键重复的数据
                    baseMapper.delete(Wrappers.query(peRolePermissionEntity));
                    // 重新插入数据
                    b = baseMapper.insert(peRolePermissionEntity) > 0;
                }
            }
            // 如果为false 则出现添加失败 事务回滚
            if (!b) {
                throw new CommonException(ResultCode.FAIL);
            }

        }
        // 都没有出现问题 则添加成功
        return true;*/
        return this.saveBatch(entitySet);
    }

}