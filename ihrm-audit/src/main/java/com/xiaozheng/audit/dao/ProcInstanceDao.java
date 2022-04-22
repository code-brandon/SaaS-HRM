package com.xiaozheng.audit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.proc.ProcInstanceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 流程 拓展表  -- 业务流程实例表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Mapper
@Repository
public interface ProcInstanceDao extends BaseMapper<ProcInstanceEntity> {

    List<Map<String, String>> selectBsUsers(@Param("sqlStrs") List<String> sqlStrs);
}
