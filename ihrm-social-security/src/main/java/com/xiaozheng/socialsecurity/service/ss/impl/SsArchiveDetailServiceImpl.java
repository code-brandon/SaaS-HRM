package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.*;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.model.ss.SsCityPaymentItemEntity;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsArchiveDetailDao;
import com.xiaozheng.socialsecurity.dao.ss.SsCityPaymentItemDao;
import com.xiaozheng.socialsecurity.dao.ss.SsUserSocialSecurityDao;
import com.xiaozheng.socialsecurity.service.ss.SsArchiveDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanMap;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 社保-归档详情实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssArchiveDetailService")
public class SsArchiveDetailServiceImpl extends ServiceImpl<SsArchiveDetailDao, SsArchiveDetailEntity> implements SsArchiveDetailService {

    @Autowired
    private SsCityPaymentItemDao ssCityPaymentItemDao;

    @Autowired
    private SsUserSocialSecurityDao ssUserSocialSecurityDao;

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

        boolean bCount = baseMapper.selectPage(new Page<>(1, 1), new QueryWrapper<SsArchiveDetailEntity>().eq("years_month", ssArchiveDetail.getYearsMonth())).getRecords().size() > 0;

        if (bCount) {
            // 有存档，直接根据年份和企业ID查询详情
            return new PageUtils<>(baseMapper.pageAndTran(
                    new Query<SsArchiveDetailEntity>().getPage(params),
                    ssArchiveDetail,
                    companyId
            ));
        } else {
            // 没有存档，根据用户社保表、社保-城市与缴费项目关联表计算组装详细表数据
            // 社保-城市与缴费项目关联表数据
            List<SsCityPaymentItemEntity> cityPaymentItemList = ssCityPaymentItemDao.selectList(Wrappers.<SsCityPaymentItemEntity>lambdaQuery());
            // 对数据进行分组，分组字段为城市ID
            Map<String, List<SsCityPaymentItemEntity>> groupCityPayment = cityPaymentItemList.stream().collect(Collectors.groupingBy(SsCityPaymentItemEntity::getCityId));

            // 构建社保详细表分页数据
            Page<SsArchiveDetailEntity> archiveDetailEntityIPage = new Page<>();

            //查询用户的社保列表 (用户和基本社保数据)
            IPage<SsUserSocialSecurityDto> ssUserSocialSecurityDtoIPage = ssUserSocialSecurityDao.pageAndTran(new Query<SsUserSocialSecurityEntity>().getPage(params), new SsUserSocialSecurityEntity(), companyId);
            BeanUtils.copyProperties(ssUserSocialSecurityDtoIPage, archiveDetailEntityIPage);

            // 组装计算的结果集
            List<SsArchiveDetailEntity> collect =
                    ssUserSocialSecurityDtoIPage.getRecords().stream().map(item -> PublicMethodSetUtils.userSocialSecurityDtoToArchiveDetail(
                            BeanMapUtils.beanToMap(ssArchiveDetail),
                            groupCityPayment,
                            item)).collect(Collectors.toList());
            archiveDetailEntityIPage.setRecords(collect);
            return new PageUtils<>(archiveDetailEntityIPage);
        }
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