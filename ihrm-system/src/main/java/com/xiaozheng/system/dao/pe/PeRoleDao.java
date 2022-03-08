package com.xiaozheng.system.dao.pe;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.dto.PeRoleDto;
import com.xiaozheng.model.pe.PeRoleEntity;
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
public interface PeRoleDao extends BaseMapper<PeRoleEntity> {

    /**
     * 通过主键查询单条数据和所关联权限
     *
     * @param id 主键
     * @return 单条数据
     */
    PeRoleDto infoAndPermById(@Param("id") String id);
}
