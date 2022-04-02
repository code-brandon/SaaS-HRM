package com.xiaozheng.socialsecurity.dao.ss;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 社保-用户社保信息表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Mapper
@Repository
public interface SsUserSocialSecurityDao extends BaseMapper<SsUserSocialSecurityEntity> {

    /**
     * 分页条件查询所有翻译数据
     *
     * @param page
     * @param ssUserSocialSecurity
     * @return
     */
    IPage<SsUserSocialSecurityDto> pageAndTran(@Param("page") IPage<SsUserSocialSecurityEntity> page, @Param("ssUserSocialSecurity") SsUserSocialSecurityEntity ssUserSocialSecurity, @Param("companyId") String companyId);
    List<SsUserSocialSecurityDto> pageAndTran(@Param("ssUserSocialSecurity") SsUserSocialSecurityEntity ssUserSocialSecurity, @Param("companyId") String companyId);

    /**
     * 通过主键查询单条翻译数据
     *
     * @param userId 主键
     * @return 单条数据
     */
    SsUserSocialSecurityDto getByIdAndTran(@Param("userId") String userId);
}
