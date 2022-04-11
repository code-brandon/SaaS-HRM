package com.xiaozheng.salary.dao;

import com.xiaozheng.model.sa.SaArchiveDetailEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 工资-归档详情
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Mapper
@Repository
public interface SaArchiveDetailDao extends BaseMapper<SaArchiveDetailEntity> {
	
}
