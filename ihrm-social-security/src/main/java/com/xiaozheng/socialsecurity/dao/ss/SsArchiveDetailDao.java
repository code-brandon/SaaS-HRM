package com.xiaozheng.socialsecurity.dao.ss;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 社保-归档详情
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Mapper
@Repository
public interface SsArchiveDetailDao extends BaseMapper<SsArchiveDetailEntity> {

    /**
     * 分页条件查询用户所在企业所有翻译数据
     *
     * @param ssArchiveDetail
     * @return 所有数据
     */
    IPage<SsArchiveDetailEntity> pageAndTran(@Param("page") IPage<SsArchiveDetailEntity> page, @Param("ssArchiveDetail") SsArchiveDetailEntity ssArchiveDetail, @Param("companyId") String companyId);

    // @MapKey("yearsMonth")
    List<Map<String, Object>> getCountArchiveDetail(@Param("yearsMonth") String yearsMonth);
}
