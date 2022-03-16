package com.xiaozheng.company.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.co.CoDepartmentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@Mapper
@Repository
public interface CoDepartmentDao extends BaseMapper<CoDepartmentEntity> {

}
