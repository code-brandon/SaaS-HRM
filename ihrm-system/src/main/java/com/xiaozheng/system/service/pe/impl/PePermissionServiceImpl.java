package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.PermissionConstants;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.system.dao.pe.PePermissionApiDao;
import com.xiaozheng.system.dao.pe.PePermissionDao;
import com.xiaozheng.system.dao.pe.PePermissionMenuDao;
import com.xiaozheng.system.dao.pe.PePermissionPointDao;
import com.xiaozheng.system.service.pe.PePermissionService;
import com.xiaozheng.model.pe.PePermissionApiEntity;
import com.xiaozheng.model.pe.PePermissionEntity;
import com.xiaozheng.model.pe.PePermissionMenuEntity;
import com.xiaozheng.model.pe.PePermissionPointEntity;
import com.xiaozheng.model.vo.pe.PePermissionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("pePermissionService")
public class PePermissionServiceImpl extends ServiceImpl<PePermissionDao, PePermissionEntity> implements PePermissionService {

    @Autowired
    private PePermissionMenuDao permissionMenuDao;

    @Autowired
    private PePermissionApiDao permissionApiDao;

    @Autowired
    private PePermissionPointDao permissionPointDao;

    @Override
    public PageUtils<PePermissionEntity> queryPage(PePermissionEntity pePermission, Map<String, Object> params) {
        QueryWrapper<PePermissionEntity> queryWrapper = new QueryWrapper<PePermissionEntity>();
        if (pePermission.getType() == 0) {
            queryWrapper.in( "type", 1, 2);
            queryWrapper.eq(Objects.nonNull(pePermission.getPid()),"pid", pePermission.getPid());
            queryWrapper.eq("en_visible", pePermission.getEnVisible());
        }

        IPage<PePermissionEntity> page = this.page(
                new Query<PePermissionEntity>().getPage(params),
                pePermission.getType() != 0 ? queryWrapper.setEntity(pePermission) : queryWrapper
        );

        return new PageUtils(page);
    }

    /**
     * 按类型保存权限
     *
     * @param pePermissionVo
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveByType(PePermissionVo pePermissionVo) throws Exception {
        PePermissionEntity pePermissionEntity = new PePermissionEntity();
        BeanUtils.copyProperties(pePermissionVo, pePermissionEntity);

        if (baseMapper.insert(pePermissionEntity) < 0) {
            throw new CommonException(ResultCode.FAIL);
        }

        int insert = -1;
        switch (pePermissionVo.getType()) {
            case PermissionConstants.PERMISSION_MENU:
                PePermissionMenuEntity permissionMenuEntity = new PePermissionMenuEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionMenuEntity);
                permissionMenuEntity.setId(pePermissionEntity.getId());
                insert = permissionMenuDao.insert(permissionMenuEntity);
                break;
            case PermissionConstants.PERMISSION_POINT:
                PePermissionPointEntity permissionPointEntity = new PePermissionPointEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionPointEntity);
                permissionPointEntity.setId(pePermissionEntity.getId());
                insert = permissionPointDao.insert(permissionPointEntity);
                break;
            case PermissionConstants.PERMISSION_API:
                PePermissionApiEntity permissionApiEntity = new PePermissionApiEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionApiEntity);
                permissionApiEntity.setId(pePermissionEntity.getId());
                insert = permissionApiDao.insert(permissionApiEntity);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }
        if (insert < 0) {
            throw new CommonException(ResultCode.FAIL);
        }
        return insert > 0;
    }

    /**
     * 按类型和ID修改权限
     *
     * @param pePermissionVo
     * @return
     */
    @Override
    public boolean updateByIdAndType(PePermissionVo pePermissionVo) throws Exception {
        PePermissionEntity pePermissionEntity = baseMapper.selectById(pePermissionVo.getId());

        BeanUtils.copyProperties(pePermissionVo, pePermissionEntity,new String[]{"id"});
        pePermissionEntity.setType(pePermissionVo.getType());

        if (baseMapper.updateById(pePermissionEntity) < 0) {
            throw new CommonException(ResultCode.FAIL);
        }
        int update = -1;
        switch (pePermissionVo.getType()) {
            case PermissionConstants.PERMISSION_MENU:
                PePermissionMenuEntity permissionMenuEntity = new PePermissionMenuEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionMenuEntity);
                permissionMenuEntity.setId(pePermissionEntity.getId());
                update = permissionMenuDao.updateById(permissionMenuEntity);
                break;
            case PermissionConstants.PERMISSION_POINT:
                PePermissionPointEntity permissionPointEntity = new PePermissionPointEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionPointEntity);
                permissionPointEntity.setId(pePermissionEntity.getId());
                update = permissionPointDao.updateById(permissionPointEntity);
                break;
            case PermissionConstants.PERMISSION_API:
                PePermissionApiEntity permissionApiEntity = new PePermissionApiEntity();
                BeanUtils.copyProperties(pePermissionVo, permissionApiEntity);
                permissionApiEntity.setId(pePermissionEntity.getId());
                update = permissionApiDao.updateById(permissionApiEntity);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }

        if (update < 0) {
            throw new CommonException(ResultCode.FAIL);
        }

        return update > 0;
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public PePermissionVo queryById(String id) throws Exception {

        PePermissionVo pePermissionVo = new PePermissionVo();

        PePermissionEntity pePermissionEntity = baseMapper.selectById(id);
        BeanUtils.copyProperties(pePermissionEntity, pePermissionVo,PePermissionVo.class);
        switch (pePermissionEntity.getType()) {
            case PermissionConstants.PERMISSION_MENU:
                PePermissionMenuEntity pePermissionMenuEntity = permissionMenuDao.selectById(pePermissionEntity.getId());
                BeanUtils.copyProperties(pePermissionMenuEntity, pePermissionVo);
                break;
            case PermissionConstants.PERMISSION_POINT:
                PePermissionPointEntity pePermissionPointEntity = permissionPointDao.selectById(pePermissionEntity.getId());
                BeanUtils.copyProperties(pePermissionPointEntity, pePermissionVo,new String[]{"id"});
                break;
            case PermissionConstants.PERMISSION_API:
                PePermissionApiEntity pePermissionApiEntity = permissionApiDao.selectById(pePermissionEntity.getId());
                BeanUtils.copyProperties(pePermissionApiEntity, pePermissionVo);
                break;
            default:
                throw new CommonException(ResultCode.FAIL);
        }

        return pePermissionVo;
    }

    @Override
    public boolean removeByIdAndType(List<String> asList) throws Exception{

        List<PePermissionEntity> entities = baseMapper.selectList(new QueryWrapper<PePermissionEntity>().in("id", asList));
        for (PePermissionEntity item : entities){

            if (baseMapper.deleteById(item.getId()) < 0) {
                throw new CommonException(ResultCode.FAIL);
            }
            int delete = -1;
            switch (item.getType()) {
                case PermissionConstants.PERMISSION_MENU:
                    delete = permissionMenuDao.deleteById(item.getId());
                    break;
                case PermissionConstants.PERMISSION_POINT:
                    delete = permissionPointDao.deleteById(item.getId());
                    break;
                case PermissionConstants.PERMISSION_API:
                    delete = permissionApiDao.deleteById(item.getId());
                    break;
                default:
                    throw new CommonException(ResultCode.FAIL);
            }

            if (delete < 0) {
                throw new CommonException(ResultCode.FAIL);
            }
        }
        return true;
    }

    /**
     * 按用户 ID 或 EnVisible 查询
     * @param userId
     * @param level
     * @return
     */
    @Override
    public Map<String, Object> queryByUserIdOrEnVisible(String userId, String level) {
        List<PePermissionEntity> permissions = null;
        switch (level.toLowerCase()) {
            case "saasadmin":
                //1.SAAS平台管理员具有所有的权限
                permissions = list();
                break;
            case "coadmin":
                //2.企业管理员具有所有的企业权限
                permissions = list(new QueryWrapper<PePermissionEntity>().eq("en_visible", 1));
                break;
            default:
                //3.企业用户具有当前角色的权限
                permissions = baseMapper.queryByUserId(userId);
        }

        Map<Integer, List<String>> listMap = permissions.stream().collect(Collectors.groupingBy(PePermissionEntity::getType, Collectors.mapping(PePermissionEntity::getCode, Collectors.toList())));
        Map<String, Object> permMap = Maps.newHashMap();
        permMap.put("menus", listMap.get(1));
        permMap.put("points", listMap.get(2));
        permMap.put("apis", listMap.get(3));
        return permMap;
    }


}