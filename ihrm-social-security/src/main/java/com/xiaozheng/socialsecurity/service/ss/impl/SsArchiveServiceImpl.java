package com.xiaozheng.socialsecurity.service.ss.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.BeanUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.PublicMethodSetUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.model.ss.SsArchiveEntity;
import com.xiaozheng.model.ss.SsCityPaymentItemEntity;
import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import com.xiaozheng.socialsecurity.dao.ss.SsArchiveDao;
import com.xiaozheng.socialsecurity.dao.ss.SsArchiveDetailDao;
import com.xiaozheng.socialsecurity.dao.ss.SsCityPaymentItemDao;
import com.xiaozheng.socialsecurity.dao.ss.SsUserSocialSecurityDao;
import com.xiaozheng.socialsecurity.service.ss.SsArchiveDetailService;
import com.xiaozheng.socialsecurity.service.ss.SsArchiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 社保-归档表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@Service("ssArchiveService")
public class SsArchiveServiceImpl extends ServiceImpl<SsArchiveDao, SsArchiveEntity> implements SsArchiveService {

    @Autowired
    private SsArchiveDetailDao saleArchiveDetailDao;

    @Autowired
    private SsUserSocialSecurityDao ssUserSocialSecurityDao;

    @Autowired
    private SsArchiveDetailService SsArchiveDetailService;

    @Autowired
    private SsCityPaymentItemDao ssCityPaymentItemDao;

    @Override
    public PageUtils<SsArchiveEntity> queryPage(SsArchiveEntity ssArchive, Map<String, Object> params) {
        IPage<SsArchiveEntity> page = this.page(
                new Query<SsArchiveEntity>().getPage(params),
                Wrappers.query(ssArchive)
        );
        return new PageUtils(page);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveArchive(SsArchiveEntity ssArchive) throws CommonException {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        SsArchiveEntity ssArchiveEntity = baseMapper.selectOne(Wrappers.<SsArchiveEntity>lambdaQuery().eq(SsArchiveEntity::getYearsMonth, ssArchive.getYearsMonth()));
        boolean aNull = Objects.nonNull(ssArchiveEntity);
        if (aNull) {
            // 不为空 为更新操作
            return updateArchAndDetail(ssArchive, companyId, ssArchiveEntity);
        }
        // 如果获取的归档为空 新建归档保存数据
        ssArchiveEntity = aNull ? ssArchiveEntity : new SsArchiveEntity();
        List<SsCityPaymentItemEntity> cityPaymentItemList = ssCityPaymentItemDao.selectList(Wrappers.lambdaQuery());
        Map<String, List<SsCityPaymentItemEntity>> groupCityPayment = cityPaymentItemList.stream().collect(Collectors.groupingBy(SsCityPaymentItemEntity::getCityId));
        // 用户社保信息
        List<SsUserSocialSecurityDto> securityDtos = ssUserSocialSecurityDao.pageAndTran(new SsUserSocialSecurityEntity(), companyId);
        // 构建社保详情的数据
        List<SsArchiveDetailEntity> collect = securityDtos.stream().map(item -> PublicMethodSetUtils.userSocialSecurityDtoToArchiveDetail(BeanUtils.beanToMap(ssArchive), groupCityPayment, item)).collect(Collectors.toList());

        // 保存归档
        boolean b = SsArchiveDetailService.saveBatch(collect);
        boolean c = updateArchAndDetail(ssArchive, companyId, ssArchiveEntity);
        if (!b && !c) {
            // 失败 抛出异常事务回滚
            throw new CommonException(ResultCode.FAIL);
        }
        // 没有任何问题返回true
        return true;
    }

    /**
     * 根据年份模糊查询历史归档
     *
     * @param years
     * @return
     */
    @Override
    public List<Map<String, Object>> archiveHistoryByYears(String years) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        return baseMapper.selectMaps(Wrappers.<SsArchiveEntity>lambdaQuery().eq(SsArchiveEntity::getCompanyId, companyId).like(SsArchiveEntity::getYearsMonth, years + "%"));
    }

    private boolean updateArchAndDetail(SsArchiveEntity ssArchive, String companyId, SsArchiveEntity ssArchiveEntity) throws CommonException {
        // 获取月份的统计数据
        Map<String, Object> countArchiveDetail = saleArchiveDetailDao.getCountArchiveDetail(ssArchive.getYearsMonth()).get(0);
        Object countEnterprise = countArchiveDetail.get("countEnterprise");
        Object countIndividual = countArchiveDetail.get("countIndividual");
        Object countSum = countArchiveDetail.get("countSum");
        // 填充数据
        ssArchiveEntity.setCompanyId(companyId);
        ssArchiveEntity.setYearsMonth(ssArchive.getYearsMonth());
        ssArchiveEntity.setEnterprisePayment(Objects.nonNull(countEnterprise) && countEnterprise instanceof BigDecimal ? (BigDecimal) countEnterprise : new BigDecimal(0));
        ssArchiveEntity.setPersonalPayment(Objects.nonNull(countIndividual) && countIndividual instanceof BigDecimal ? (BigDecimal) countIndividual : new BigDecimal(0));
        ssArchiveEntity.setTotal(Objects.nonNull(countSum) && countSum instanceof BigDecimal ? (BigDecimal) countSum : new BigDecimal(0));
        if (!this.saveOrUpdate(ssArchiveEntity, Wrappers.<SsArchiveEntity>lambdaQuery().eq(SsArchiveEntity::getCompanyId, companyId).eq(SsArchiveEntity::getYearsMonth, ssArchive.getYearsMonth()))) {
            // 更新或保存失败 抛出异常代码回滚
            throw new CommonException(ResultCode.FAIL);
        }
        SsArchiveDetailEntity ssArchiveDetailEntity = new SsArchiveDetailEntity();
        ssArchiveDetailEntity.setArchiveId(ssArchiveEntity.getId());
        // 更新详情数据
        return saleArchiveDetailDao.update(ssArchiveDetailEntity, Wrappers.<SsArchiveDetailEntity>lambdaQuery().eq(SsArchiveDetailEntity::getYearsMonth, ssArchiveEntity.getYearsMonth())) > 0;
    }

}