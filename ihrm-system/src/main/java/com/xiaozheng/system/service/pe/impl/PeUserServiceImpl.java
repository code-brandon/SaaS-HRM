package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import com.xiaozheng.common.utils.JwtUtils;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.system.dao.pe.PeUserDao;
import com.xiaozheng.system.service.pe.PePermissionService;
import com.xiaozheng.system.service.pe.PeUserService;
import com.xiaozheng.model.dto.PeUserDto;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peUserService")
public class PeUserServiceImpl extends ServiceImpl<PeUserDao, PeUserEntity> implements PeUserService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PePermissionService pePermissionService;

    @Override
    public PageUtils<PeUserEntity> queryPage(PeUserEntity peUser, Map<String, Object> params) {
        IPage<PeUserEntity> page = this.page(
                new Query<PeUserEntity>().getPage(params),
                Wrappers.query(peUser)
        );
        return new PageUtils(page);
    }

    /**
     * 通过主键查询单条数据和所关联角色
     *
     * @param id
     * @return
     */
    @Override
    public PeUserEntity infoAndRoleById(String id) {
        return baseMapper.infoAndRoleById(id);
    }

    /**
     * 根据Mobile 查询用户
     * @param mobile
     * @return
     */
    @Override
    public PeUserEntity queryByMobile(String mobile) {
        return baseMapper.selectOne(new QueryWrapper<PeUserEntity>().eq("mobile", mobile));
    }

    /**
     * 用户登录
     * @param usetVo
     * @return
     */
    @Override
    public String login(PeUsetVo usetVo) {
        PeUserEntity peUserEntity = this.queryByMobile(usetVo.getMobile());
        if (Objects.isNull(peUserEntity) || !peUserEntity.getPassword().equals(usetVo.getPassword())) {
            // 登录失败
            return null;
        }
        // 登录成功
        Map<String, Object> map = Maps.newHashMap();
        map.put("companyId", peUserEntity.getCompanyId());
        map.put("companyName", peUserEntity.getCompanyName());
        return jwtUtils.createJwt(peUserEntity.getId(), peUserEntity.getUsername(), map);
    }

    /**
     * 获取个人信息
     *
     * @param userId
     * @return
     */
    @Override
    public PeUserDto profile(String userId) {
        PeUserDto peUserDto = new PeUserDto();
        PeUserEntity peUserEntity = baseMapper.selectById(userId);
        BeanUtils.copyProperties(peUserEntity, peUserDto);

        // 获取权限
        Map<String, Object> permMap = pePermissionService.queryByUserIdOrEnVisible(peUserEntity.getId(),peUserEntity.getLevel());
        peUserDto.setRoles(permMap);

        return peUserDto;
    }

}