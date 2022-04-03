package com.xiaozheng.attendance.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.atte.AtteArchiveMonthlyInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 考勤归档信息详情表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Mapper
@Repository
public interface AtteArchiveMonthlyInfoDao extends BaseMapper<AtteArchiveMonthlyInfoEntity> {
	
}
