package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsArchiveDetailDao;
import com.xiaozheng.socialsecurity.service.ss.SsArchiveDetailService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 社保-归档详情实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssArchiveDetailService")
public class SsArchiveDetailServiceImpl extends ServiceImpl<SsArchiveDetailDao, SsArchiveDetailEntity> implements SsArchiveDetailService {

    @Override
    public PageUtils<SsArchiveDetailEntity> queryPage(SsArchiveDetailEntity ssArchiveDetail, Map<String, Object> params) {
        IPage<SsArchiveDetailEntity> page = this.page(
                new Query<SsArchiveDetailEntity>().getPage(params),
                Wrappers.query(ssArchiveDetail)
        );
        return new PageUtils(page);
    }

    /**
     * 分页条件查询用户所在企业所有翻译数据
     *
     * @param ssArchiveDetail
     * @param params          请求集合
     * @return 所有数据
     */
    @Override
    public PageUtils<SsArchiveDetailEntity> queryPageAndTran(SsArchiveDetailEntity ssArchiveDetail, Map<String, Object> params) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();

        return new PageUtils(baseMapper.pageAndTran(
                new Query<SsArchiveDetailEntity>().getPage(params),
                ssArchiveDetail,
                companyId
        ));
    }

    /**
     * 根据年月获取统计存档详细信息
     *
     * @param yearsMonth
     * @return
     */
    @Override
    public Map<String, Object> getCountArchiveDetail(String yearsMonth) {
        List<Map<String, Object>> countArchiveDetail = baseMapper.getCountArchiveDetail(yearsMonth);
        return CollectionUtils.isNotEmpty(countArchiveDetail) ? countArchiveDetail.get(0) : null;
    }

}