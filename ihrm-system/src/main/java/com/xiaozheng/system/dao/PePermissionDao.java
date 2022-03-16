package com.xiaozheng.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.pe.PePermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Mapper
@Repository
public interface PePermissionDao extends BaseMapper<PePermissionEntity> {

    /**
     * 根据pid和type获取权限
     * @param type
     * @param permIds
     * @return
     */
    List<PePermissionEntity> queryByTypeAndPid(@Param("type") Integer type, @Param("permIds") Set<String> permIds);

    /**
     * 根据用户名查询权限
     * @param userId
     * @return
     */
    List<PePermissionEntity> queryByUserId(@Param("userId") String userId);
}
