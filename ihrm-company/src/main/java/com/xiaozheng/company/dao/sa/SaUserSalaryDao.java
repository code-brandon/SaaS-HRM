package com.xiaozheng.company.dao.sa;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.sa.SaUserSalaryEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 工资-员工薪资表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@Mapper
@Repository
public interface SaUserSalaryDao extends BaseMapper<SaUserSalaryEntity> {

}
