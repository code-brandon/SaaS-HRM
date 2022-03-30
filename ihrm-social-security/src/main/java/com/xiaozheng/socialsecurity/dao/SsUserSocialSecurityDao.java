package com.xiaozheng.socialsecurity.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 社保-用户社保信息表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Mapper
@Repository
public interface SsUserSocialSecurityDao extends BaseMapper<SsUserSocialSecurityEntity> {
	
}
