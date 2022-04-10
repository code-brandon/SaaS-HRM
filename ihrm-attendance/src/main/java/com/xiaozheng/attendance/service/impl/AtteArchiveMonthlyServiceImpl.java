package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteArchiveMonthlyDao;
import com.xiaozheng.attendance.dao.AtteArchiveMonthlyInfoDao;
import com.xiaozheng.attendance.service.AtteArchiveMonthlyInfoService;
import com.xiaozheng.attendance.service.AtteArchiveMonthlyService;
import com.xiaozheng.attendance.service.AtteCompanySettingsService;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.atte.AtteArchiveMonthlyEntity;
import com.xiaozheng.model.atte.AtteArchiveMonthlyInfoEntity;
import com.xiaozheng.model.atte.AtteCompanySettingsEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 考勤归档信息表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteArchiveMonthlyService")
public class AtteArchiveMonthlyServiceImpl extends ServiceImpl<AtteArchiveMonthlyDao, AtteArchiveMonthlyEntity> implements AtteArchiveMonthlyService {

    @Autowired
    private AtteArchiveMonthlyInfoDao atteArchiveMonthlyInfoDao;

    @Autowired
    private AtteArchiveMonthlyInfoService atteArchiveMonthlyInfoService;

    @Autowired
    private AtteCompanySettingsService atteCompanySettingsService;

    @Override
    public PageUtils<AtteArchiveMonthlyEntity> queryPage(AtteArchiveMonthlyEntity atteArchiveMonthly,Map<String, Object> params) {
        IPage<AtteArchiveMonthlyEntity> page = this.page(
                new Query<AtteArchiveMonthlyEntity>().getPage(params),
                Wrappers.query(atteArchiveMonthly)
        );
        return new PageUtils(page);
    }

    /**
     * 保存考勤归档数据
     * @param atteArchiveMonthly
     * @return
     * @throws CommonException
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveArchive(AtteArchiveMonthlyEntity atteArchiveMonthly) throws CommonException {
        // 归档年月不能为空
        if (StringUtils.isBlank(atteArchiveMonthly.getArchiveYear()) || StringUtils.isBlank(atteArchiveMonthly.getArchiveMonth())) {
            throw new CommonException(ResultCode.FAIL);
        }
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo = new AtteArchiveMonthlyInfoEntity();
        atteArchiveMonthlyInfo.setArchiveDate(atteArchiveMonthly.getArchiveYear() + atteArchiveMonthly.getArchiveMonth());

        AtteArchiveMonthlyEntity atteArchiveEntity = baseMapper.selectOne(
                Wrappers.<AtteArchiveMonthlyEntity>lambdaQuery()
                        .eq(AtteArchiveMonthlyEntity::getArchiveYear, atteArchiveMonthly.getArchiveYear())
                        .eq(AtteArchiveMonthlyEntity::getArchiveMonth, atteArchiveMonthly.getArchiveMonth())
                        .eq(AtteArchiveMonthlyEntity::getCompanyId, companyId));
        boolean aNull = Objects.nonNull(atteArchiveEntity);
        if (aNull) {
            // 不为空 为更新操作
            List<AtteArchiveMonthlyInfoEntity> infoEntities = atteArchiveMonthlyInfoDao.pageAndDate(atteArchiveMonthlyInfo, companyId);
            // 总人数
            atteArchiveEntity.setTotalPeopleNum(infoEntities.size());
            // 全勤人数  TODO  默认全勤 以后有时间进行计算统计
            atteArchiveEntity.setFullAttePeopleNum(infoEntities.size());
            atteArchiveEntity.setIsArchived(0);
            // 更新数据
            return baseMapper.updateById(atteArchiveEntity) > 0;
        }
        // 如果获取的归档为空 新建归档保存数据
        atteArchiveEntity = aNull ? atteArchiveEntity : new AtteArchiveMonthlyEntity();
        BeanUtils.copyProperties(atteArchiveMonthly, atteArchiveEntity);
        atteArchiveEntity.setCompanyId(companyId);
        // 保存归档表
        baseMapper.insert(atteArchiveEntity);
        Long atteArchiveMonthlyId = atteArchiveEntity.getId();

        List<AtteArchiveMonthlyInfoEntity> monthlyInfoEntities = atteArchiveMonthlyInfoDao.pageAndDate(atteArchiveMonthlyInfo, companyId).stream().map(item -> {
            item.setAtteArchiveMonthlyId(atteArchiveMonthlyId);
            return item;
        }).collect(Collectors.toList());

        // 保存归档详情表数据
        if (!atteArchiveMonthlyInfoService.saveBatch(monthlyInfoEntities)) {
            // 更新或保存失败 抛出异常代码回滚
            throw new CommonException(ResultCode.FAIL);
        }
        // 总人数
        atteArchiveEntity.setTotalPeopleNum(monthlyInfoEntities.size());
        // 全勤人数  TODO  默认全勤 以后有时间进行计算统计
        atteArchiveEntity.setFullAttePeopleNum(monthlyInfoEntities.size());
        atteArchiveEntity.setIsArchived(0);
        // 没有任何问题返回true
        if (baseMapper.updateById(atteArchiveEntity) > 0) {
            AtteCompanySettingsEntity atteCompanySettingsEntity = new AtteCompanySettingsEntity(companyId, 1, atteArchiveEntity.getArchiveYear() + atteArchiveEntity.getArchiveMonth());
            return atteCompanySettingsService.saveOrUpdate(atteCompanySettingsEntity, Wrappers.lambdaUpdate(atteCompanySettingsEntity).eq(AtteCompanySettingsEntity::getCompanyId, companyId));

        }
        // 没有正常返回，抛出异常 数据回滚
        throw new CommonException(ResultCode.FAIL);
    }

}