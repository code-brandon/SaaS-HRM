package com.xiaozheng.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.pe.PeUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Mapper
@Repository
public interface PeUserDao extends BaseMapper<PeUserEntity> {

    PeUserEntity infoAndRoleById(@Param("id") String id);

    PeUserEntity infoAndRoleByMobile(@Param("mobile") String mobile);
}
