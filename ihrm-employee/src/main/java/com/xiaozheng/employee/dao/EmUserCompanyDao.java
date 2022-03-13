package com.xiaozheng.employee.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.em.EmUserCompanyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Mapper
@Repository
public interface EmUserCompanyDao extends BaseMapper<EmUserCompanyEntity> {
	
}
