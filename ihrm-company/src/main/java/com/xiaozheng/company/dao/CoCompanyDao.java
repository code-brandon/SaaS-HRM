package com.xiaozheng.company.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.co.CoCompanyEntity;
import org.springframework.stereotype.Repository;

/**
 * 自定义dao接口继承
 * JpaRepository<实体类，主键>
 * JpaSpecificationExecutor<实体类>
 */
@Repository
public interface CoCompanyDao extends BaseMapper<CoCompanyEntity> {
}
