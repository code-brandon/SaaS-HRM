package com.xiaozheng.attendance.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaozheng.model.atte.AtteAttendanceEntity;
import com.xiaozheng.model.bo.AtteAttendanceBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 考勤表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Mapper
@Repository
public interface AtteAttendanceDao extends BaseMapper<AtteAttendanceEntity> {

    /**
     * 分页条件查询用户考勤
     * @param page
     * @param atteAttendance
     * @param companyId
     * @return
     */
    IPage<AtteAttendanceBo> queryAtte(@Param("page") IPage<AtteAttendanceBo> page, @Param("atteAttendance") AtteAttendanceEntity atteAttendance, @Param("companyId") String companyId);
}
