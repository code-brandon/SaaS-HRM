package com.xiaozheng.employee.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.dto.UserDetailAndResignationDto;
import com.xiaozheng.model.em.EmArchiveEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Mapper
@Repository
public interface EmArchiveDao extends BaseMapper<EmArchiveEntity> {

    /**
     * 根据 企业ID 和 日期 导出当月人事报表
     * @param companyId
     * @param month
     * @return
     */
    List<UserDetailAndResignationDto> exportBycompanyIdAndMonth(@Param("companyId") String companyId, @Param("month") String month);
}
