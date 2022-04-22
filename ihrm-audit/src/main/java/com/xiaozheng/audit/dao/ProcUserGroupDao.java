package com.xiaozheng.audit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.proc.ProcUserGroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 流程 拓展表 -- 业务流程的用户组表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Mapper
@Repository
public interface ProcUserGroupDao extends BaseMapper<ProcUserGroupEntity> {
	
}
