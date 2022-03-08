package com.xiaozheng.company.dao.sa;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.sa.SaSettingsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 工资-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@Mapper
@Repository
public interface SaSettingsDao extends BaseMapper<SaSettingsEntity> {

}
