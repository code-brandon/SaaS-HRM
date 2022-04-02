package com.xiaozheng.socialsecurity.dao.bs;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaozheng.model.bs.BsPermissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * bs_许可
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@Mapper
@Repository
public interface BsPermissionDao extends BaseMapper<BsPermissionEntity> {

}
