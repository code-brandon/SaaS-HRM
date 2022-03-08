package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 工资-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("工资-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_settings")
public class SaSettingsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业id
     */
    @ApiModelProperty("企业id")
    @TableId(type = IdType.ASSIGN_ID)
    private String companyId;
    /**
     * 对应社保自然月
     */
    @ApiModelProperty("对应社保自然月")
    private Integer socialSecurityType;
    /**
     * 津贴方案名称
     */
    @ApiModelProperty("津贴方案名称")
    private String subsidyName;
    /**
     * 津贴备注
     */
    @ApiModelProperty("津贴备注")
    private String subsidyRemark;
    /**
     * 交通补贴计算类型
     */
    @ApiModelProperty("交通补贴计算类型")
    private Integer transportationSubsidyScheme;
    /**
     * 交通补贴金额
     */
    @ApiModelProperty("交通补贴金额")
    private BigDecimal transportationSubsidyAmount;
    /**
     * 通讯补贴计算类型
     */
    @ApiModelProperty("通讯补贴计算类型")
    private Integer communicationSubsidyScheme;
    /**
     * 通讯补贴金额
     */
    @ApiModelProperty("通讯补贴金额")
    private BigDecimal communicationSubsidyAmount;
    /**
     * 午餐补贴计算类型
     */
    @ApiModelProperty("午餐补贴计算类型")
    private Integer lunchAllowanceScheme;
    /**
     * 午餐补贴金额
     */
    @ApiModelProperty("午餐补贴金额")
    private BigDecimal lunchAllowanceAmount;
    /**
     * 住房补助计算类型
     */
    @ApiModelProperty("住房补助计算类型")
    private Integer housingSubsidyScheme;
    /**
     * 住房补助金额
     */
    @ApiModelProperty("住房补助金额")
    private BigDecimal housingSubsidyAmount;
    /**
     * 计税方式
     */
    @ApiModelProperty("计税方式")
    private Integer taxCalculationType;

}
