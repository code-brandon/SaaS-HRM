package com.xiaozheng.company.dao.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.sys.SysMailRecordEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 系统邮件记录表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@Mapper
@Repository
public interface SysMailRecordDao extends BaseMapper<SysMailRecordEntity> {

}
