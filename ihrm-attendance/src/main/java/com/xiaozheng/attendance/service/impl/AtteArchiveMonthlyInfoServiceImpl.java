package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteArchiveMonthlyInfoDao;
import com.xiaozheng.attendance.service.AtteArchiveMonthlyInfoService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.atte.AtteArchiveMonthlyInfoEntity;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤归档信息详情表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteArchiveMonthlyInfoService")
public class AtteArchiveMonthlyInfoServiceImpl extends ServiceImpl<AtteArchiveMonthlyInfoDao, AtteArchiveMonthlyInfoEntity> implements AtteArchiveMonthlyInfoService {

    @Override
    public PageUtils<AtteArchiveMonthlyInfoEntity> queryPage(AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo,Map<String, Object> params) {
        IPage<AtteArchiveMonthlyInfoEntity> page = this.page(
                new Query<AtteArchiveMonthlyInfoEntity>().getPage(params),
                Wrappers.query(atteArchiveMonthlyInfo)
        );
        return new PageUtils(page);
    }

    /**
     * 考勤月报
     * @param atteArchiveMonthlyInfo
     * @param params
     * @return
     */
    @Override
    public PageUtils<AtteArchiveMonthlyInfoEntity> queryPageAndDate(AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo, Map<String, Object> params) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        return new PageUtils<>(baseMapper.pageAndDate(
                new Query<SsArchiveDetailEntity>().getPage(params),
                atteArchiveMonthlyInfo,
                companyId
        ));
    }

}