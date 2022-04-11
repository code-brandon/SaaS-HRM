package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 工资-企业设置信息
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@ApiModel("工资-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_settings")
public class SaSettingsEntity extends Model<SaSettingsEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
    @ApiModelProperty(value = "企业id",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String companyId;
	/**
	 * 对应社保自然月
	 */
    @ApiModelProperty(value = "对应社保自然月",example="")
	private Integer socialSecurityType;
	/**
	 * 津贴方案名称
	 */
    @ApiModelProperty(value = "津贴方案名称",example="")
	private String subsidyName;
	/**
	 * 津贴备注
	 */
    @ApiModelProperty(value = "津贴备注",example="")
	private String subsidyRemark;
	/**
	 * 交通补贴计算类型
	 */
    @ApiModelProperty(value = "交通补贴计算类型",example="")
	private Integer transportationSubsidyScheme;
	/**
	 * 交通补贴金额
	 */
    @ApiModelProperty(value = "交通补贴金额",example="")
	private BigDecimal transportationSubsidyAmount;
	/**
	 * 通讯补贴计算类型
	 */
    @ApiModelProperty(value = "通讯补贴计算类型",example="")
	private Integer communicationSubsidyScheme;
	/**
	 * 通讯补贴金额
	 */
    @ApiModelProperty(value = "通讯补贴金额",example="")
	private BigDecimal communicationSubsidyAmount;
	/**
	 * 午餐补贴计算类型
	 */
    @ApiModelProperty(value = "午餐补贴计算类型",example="")
	private Integer lunchAllowanceScheme;
	/**
	 * 午餐补贴金额
	 */
    @ApiModelProperty(value = "午餐补贴金额",example="")
	private BigDecimal lunchAllowanceAmount;
	/**
	 * 住房补助计算类型
	 */
    @ApiModelProperty(value = "住房补助计算类型",example="")
	private Integer housingSubsidyScheme;
	/**
	 * 住房补助金额
	 */
    @ApiModelProperty(value = "住房补助金额",example="")
	private BigDecimal housingSubsidyAmount;
	/**
	 * 计税方式
	 */
    @ApiModelProperty(value = "计税方式",example="")
	private Integer taxCalculationType;

}
