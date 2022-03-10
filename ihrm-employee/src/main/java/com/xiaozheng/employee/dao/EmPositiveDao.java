package com.xiaozheng.employee.dao;

import com.xiaozheng.employee.entity.EmPositiveEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface EmPositiveDao extends BaseMapper<EmPositiveEntity> {
	
}
