package com.xiaozheng.common.utils;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.xiaozheng.model.dto.SsUserSocialSecurityDto;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;
import com.xiaozheng.model.ss.SsCityPaymentItemEntity;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * What -- 存放公共的方法
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.common.utils
 * @ClassName: PublicMethodSetUtils
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/3 19:00
 */
public class PublicMethodSetUtils {

    /**
     * 用户社保基础信息 和 社保-城市与缴费项目关联表 组装社保存档详细信息
     * @param parameter
     * @param groupCityPayment
     * @param item
     * @return 社保存档详细信息
     */
    public static  SsArchiveDetailEntity userSocialSecurityDtoToArchiveDetail(Map<String,Object> parameter, Map<String, List<SsCityPaymentItemEntity>> groupCityPayment, SsUserSocialSecurityDto item) {
        BigDecimal socialSecurityCompanyPay = new BigDecimal(0);
        BigDecimal socialSecurityPersonalPay = new BigDecimal(0);
        SsArchiveDetailEntity ssArchiveDetailEntity = new SsArchiveDetailEntity();
        BeanUtils.copyProperties(item, ssArchiveDetailEntity);
        List<SsCityPaymentItemEntity> ssCityPaymentItemEntities = groupCityPayment.get(item.getParticipatingInTheCityId());
        for (SsCityPaymentItemEntity cityPaymentItem : CollectionUtils.isNotEmpty(ssCityPaymentItemEntities) ? ssCityPaymentItemEntities : new ArrayList<SsCityPaymentItemEntity>()) {
            // 企业是否缴纳开关，0为禁用，1为启用
            if (cityPaymentItem.getSwitchCompany() == 1) {
                BigDecimal augend;
                if ("4".equals(cityPaymentItem.getPaymentItemId()) && item.getIndustrialInjuryRatio() != null) {
                    augend = item.getIndustrialInjuryRatio().multiply(BigDecimal.valueOf(item.getSocialSecurityBase() != null ? item.getSocialSecurityBase() : 0));
                } else {
                    augend = cityPaymentItem.getScaleCompany().multiply(BigDecimal.valueOf(item.getSocialSecurityBase() != null ? item.getSocialSecurityBase() : 0));
                }
                BigDecimal divideAugend = augend.divide(new BigDecimal(100));
                socialSecurityCompanyPay = socialSecurityCompanyPay.add(divideAugend);
            }
            // 个人是否缴纳开关，0为禁用，1为启用
            if (cityPaymentItem.getSwitchPersonal() == 1) {
                BigDecimal augend = cityPaymentItem.getScalePersonal().multiply(BigDecimal.valueOf(item.getSocialSecurityBase() != null ? item.getSocialSecurityBase() : 0));
                BigDecimal divideAugend = augend.divide(new BigDecimal(100));
                socialSecurityPersonalPay = socialSecurityPersonalPay.add(divideAugend);
            }
        }
        ssArchiveDetailEntity.setYearsMonth(String.valueOf(parameter.get("yearsMonth")));
        ssArchiveDetailEntity.setProportionOfPensionEnterprises(item.getEnterpriseProportion());
        ssArchiveDetailEntity.setPersonalRatioOfProvidentFund(item.getPersonalProportion());
        ssArchiveDetailEntity.setProvidentFundEnterprises(item.getEnterpriseProvidentFundPayment() != null ? item.getEnterpriseProvidentFundPayment() : new BigDecimal(0));
        ssArchiveDetailEntity.setProvidentFundIndividual(item.getPersonalProvidentFundPayment() != null ? item.getPersonalProvidentFundPayment() : new BigDecimal(0));
        ssArchiveDetailEntity.setTimeOfEntry(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        ssArchiveDetailEntity.setHouseholdRegistrationType(item.getHouseholdRegistration());
        ssArchiveDetailEntity.setParticipatingInTheCity(item.getParticipatingInTheCity());
        ssArchiveDetailEntity.setProvidentFundCity(item.getProvidentFundCity());
        ssArchiveDetailEntity.setSocialSecurityNotes(item.getSocialSecurityNotes());
        ssArchiveDetailEntity.setProvidentFundNotes(item.getProvidentFundNotes());
        ssArchiveDetailEntity.setSocialSecurityBase(BigDecimal.valueOf(item.getSocialSecurityBase() != null ? item.getSocialSecurityBase() : 0));
        ssArchiveDetailEntity.setProvidentFundBase(BigDecimal.valueOf(item.getProvidentFundBase() != null ? item.getProvidentFundBase() : 0));
        ssArchiveDetailEntity.setAccumulationFundEnterpriseBase(BigDecimal.valueOf(item.getProvidentFundBase() != null ? item.getProvidentFundBase() : 0));
        ssArchiveDetailEntity.setProportionOfProvidentFundEnterprises(item.getEnterpriseProportion());
        ssArchiveDetailEntity.setIndividualBaseOfProvidentFund(BigDecimal.valueOf(item.getProvidentFundBase() != null ? item.getProvidentFundBase() : 0));
        ssArchiveDetailEntity.setTotalProvidentFund(ssArchiveDetailEntity.getProvidentFundEnterprises().add(ssArchiveDetailEntity.getProvidentFundIndividual()));

        ssArchiveDetailEntity.setSocialSecurity(socialSecurityCompanyPay.add(socialSecurityPersonalPay));
        ssArchiveDetailEntity.setSocialSecurityEnterprise(socialSecurityCompanyPay);
        ssArchiveDetailEntity.setSocialSecurityIndividual(socialSecurityPersonalPay);
        ssArchiveDetailEntity.setSocialSecurityMonth(String.valueOf(parameter.get("yearsMonth")));
        ssArchiveDetailEntity.setProvidentFundMonth(String.valueOf(parameter.get("yearsMonth")));
        return ssArchiveDetailEntity;
    }
}
