package com.xiaozheng.model.ss;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 社保-用户社保信息表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@ApiModel("社保-用户社保信息表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ss_user_social_security")
public class SsUserSocialSecurityEntity extends Model<SsUserSocialSecurityEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
    @ApiModelProperty("用户id")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 本月是否缴纳社保 0为不缴纳 1为缴纳
	 */
    @ApiModelProperty("本月是否缴纳社保 0为不缴纳 1为缴纳")
	private Integer enterprisesPaySocialSecurityThisMonth;
	/**
	 * 本月是否缴纳公积金 0为不缴纳 1为缴纳
	 */
    @ApiModelProperty("本月是否缴纳公积金 0为不缴纳 1为缴纳")
	private Integer enterprisesPayTheProvidentFundThisMonth;
	/**
	 * 参保城市id
	 */
    @ApiModelProperty("参保城市id")
	private String participatingInTheCityId;
	/**
	 * 参保类型  1为首次开户 2为非首次开户
	 */
    @ApiModelProperty("参保类型  1为首次开户 2为非首次开户")
	private Integer socialSecurityType;
	/**
	 * 户籍类型 1为本市城镇 2为本市农村 3为外埠城镇 4为外埠农村
	 */
    @ApiModelProperty("户籍类型 1为本市城镇 2为本市农村 3为外埠城镇 4为外埠农村")
	private Integer householdRegistrationType;
	/**
	 * 社保基数
	 */
    @ApiModelProperty("社保基数")
	private Integer socialSecurityBase;
	/**
	 * 工伤比例
	 */
    @ApiModelProperty("工伤比例")
	private BigDecimal industrialInjuryRatio;
	/**
	 * 社保备注
	 */
    @ApiModelProperty("社保备注")
	private String socialSecurityNotes;
	/**
	 * 公积金城市id
	 */
    @ApiModelProperty("公积金城市id")
	private String providentFundCityId;
	/**
	 * 公积金基数
	 */
    @ApiModelProperty("公积金基数")
	private Integer providentFundBase;
	/**
	 * 公积金企业比例
	 */
    @ApiModelProperty("公积金企业比例")
	private BigDecimal enterpriseProportion;
	/**
	 * 公积金个人比例
	 */
    @ApiModelProperty("公积金个人比例")
	private BigDecimal personalProportion;
	/**
	 * 公积金企业缴纳数额
	 */
    @ApiModelProperty("公积金企业缴纳数额")
	private BigDecimal enterpriseProvidentFundPayment;
	/**
	 * 公积金个人缴纳数额
	 */
    @ApiModelProperty("公积金个人缴纳数额")
	private BigDecimal personalProvidentFundPayment;
	/**
	 * 公积金备注
	 */
    @ApiModelProperty("公积金备注")
	private String providentFundNotes;
	/**
	 * 最后修改时间
	 */
    @ApiModelProperty("最后修改时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date lastModifyTime;
	/**
	 * 社保是否缴纳变更时间
	 */
    @ApiModelProperty("社保是否缴纳变更时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date socialSecuritySwitchUpdateTime;
	/**
	 * 公积金是否缴纳变更时间
	 */
    @ApiModelProperty("公积金是否缴纳变更时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date providentFundSwitchUpdateTime;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String cityName;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String householdRegistration;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String participatingInTheCity;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String providentFundCity;

}
