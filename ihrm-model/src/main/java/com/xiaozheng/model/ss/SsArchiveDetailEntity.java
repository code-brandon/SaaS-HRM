package com.xiaozheng.model.ss;

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
 * 社保-归档详情
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@ApiModel("社保-归档详情")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ss_archive_detail")
public class SsArchiveDetailEntity extends Model<SsArchiveDetailEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty("id")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 归档id
	 */
    @ApiModelProperty("归档id")
	private String archiveId;
	/**
	 * 用户id
	 */
    @ApiModelProperty("用户id")
	private String userId;
	/**
	 * 用户名称
	 */
    @ApiModelProperty("用户名称")
	private String username;
	/**
	 * 入职时间
	 */
    @ApiModelProperty("入职时间")
	private String timeOfEntry;
	/**
	 * 手机号
	 */
    @ApiModelProperty("手机号")
	private String mobile;
	/**
	 * 身份证号
	 */
    @ApiModelProperty("身份证号")
	private String idNumber;
	/**
	 * 学历
	 */
    @ApiModelProperty("学历")
	private String theHighestDegreeOfEducation;
	/**
	 * 开户行
	 */
    @ApiModelProperty("开户行")
	private String openingBank;
	/**
	 * 银行卡号
	 */
    @ApiModelProperty("银行卡号")
	private String bankCardNumber;
	/**
	 * 一级部门
	 */
    @ApiModelProperty("一级部门")
	private String firstLevelDepartment;
	/**
	 * 二级部门
	 */
    @ApiModelProperty("二级部门")
	private String twoLevelDepartment;
	/**
	 * 工作城市
	 */
    @ApiModelProperty("工作城市")
	private String workingCity;
	/**
	 * 社保电脑号
	 */
    @ApiModelProperty("社保电脑号")
	private String socialSecurityComputerNumber;
	/**
	 * 公积金账号
	 */
    @ApiModelProperty("公积金账号")
	private String providentFundAccount;
	/**
	 * 离职时间
	 */
    @ApiModelProperty("离职时间")
	private String leaveDate;
	/**
	 * 户籍类型
	 */
    @ApiModelProperty("户籍类型")
	private String householdRegistrationType;
	/**
	 * 参保城市
	 */
    @ApiModelProperty("参保城市")
	private String participatingInTheCity;
	/**
	 * 社保月份
	 */
    @ApiModelProperty("社保月份")
	private String socialSecurityMonth;
	/**
	 * 社保基数
	 */
    @ApiModelProperty("社保基数")
	private BigDecimal socialSecurityBase;
	/**
	 * 社保合计
	 */
    @ApiModelProperty("社保合计")
	private BigDecimal socialSecurity;
	/**
	 * 社保企业
	 */
    @ApiModelProperty("社保企业")
	private BigDecimal socialSecurityEnterprise;
	/**
	 * 社保个人
	 */
    @ApiModelProperty("社保个人")
	private BigDecimal socialSecurityIndividual;
	/**
	 * 公积金城市
	 */
    @ApiModelProperty("公积金城市")
	private String providentFundCity;
	/**
	 * 公积金月份
	 */
    @ApiModelProperty("公积金月份")
	private String providentFundMonth;
	/**
	 * 公积金基数
	 */
    @ApiModelProperty("公积金基数")
	private BigDecimal providentFundBase;
	/**
	 * 公积金企业基数
	 */
    @ApiModelProperty("公积金企业基数")
	private BigDecimal accumulationFundEnterpriseBase;
	/**
	 * 公积金企业比例
	 */
    @ApiModelProperty("公积金企业比例")
	private BigDecimal proportionOfProvidentFundEnterprises;
	/**
	 * 公积金个人基数
	 */
    @ApiModelProperty("公积金个人基数")
	private BigDecimal individualBaseOfProvidentFund;
	/**
	 * 公积金个人比例
	 */
    @ApiModelProperty("公积金个人比例")
	private BigDecimal personalRatioOfProvidentFund;
	/**
	 * 公积金合计
	 */
    @ApiModelProperty("公积金合计")
	private BigDecimal totalProvidentFund;
	/**
	 * 公积金企业
	 */
    @ApiModelProperty("公积金企业")
	private BigDecimal providentFundEnterprises;
	/**
	 * 公积金个人
	 */
    @ApiModelProperty("公积金个人")
	private BigDecimal providentFundIndividual;
	/**
	 * 养老企业基数
	 */
    @ApiModelProperty("养老企业基数")
	private BigDecimal pensionEnterpriseBase;
	/**
	 * 养老企业比例
	 */
    @ApiModelProperty("养老企业比例")
	private BigDecimal proportionOfPensionEnterprises;
	/**
	 * 养老企业
	 */
    @ApiModelProperty("养老企业")
	private BigDecimal pensionEnterprise;
	/**
	 * 养老个人基数
	 */
    @ApiModelProperty("养老个人基数")
	private BigDecimal personalPensionBase;
	/**
	 * 养老个人比例
	 */
    @ApiModelProperty("养老个人比例")
	private BigDecimal personalPensionRatio;
	/**
	 * 养老个人
	 */
    @ApiModelProperty("养老个人")
	private BigDecimal oldAgeIndividual;
	/**
	 * 失业企业基数
	 */
    @ApiModelProperty("失业企业基数")
	private BigDecimal unemploymentEnterpriseBase;
	/**
	 * 失业企业比例
	 */
    @ApiModelProperty("失业企业比例")
	private BigDecimal proportionOfUnemployedEnterprises;
	/**
	 * 失业企业
	 */
    @ApiModelProperty("失业企业")
	private BigDecimal unemployedEnterprise;
	/**
	 * 失业个人基数
	 */
    @ApiModelProperty("失业个人基数")
	private BigDecimal theNumberOfUnemployedIndividuals;
	/**
	 * 失业个人比例
	 */
    @ApiModelProperty("失业个人比例")
	private BigDecimal percentageOfUnemployedIndividuals;
	/**
	 * 失业个人
	 */
    @ApiModelProperty("失业个人")
	private BigDecimal unemployedIndividual;
	/**
	 * 医疗企业基数
	 */
    @ApiModelProperty("医疗企业基数")
	private BigDecimal medicalEnterpriseBase;
	/**
	 * 医疗企业比例
	 */
    @ApiModelProperty("医疗企业比例")
	private BigDecimal proportionOfMedicalEnterprises;
	/**
	 * 医疗企业
	 */
    @ApiModelProperty("医疗企业")
	private BigDecimal medicalEnterprise;
	/**
	 * 医疗个人基数
	 */
    @ApiModelProperty("医疗个人基数")
	private BigDecimal medicalPersonalBase;
	/**
	 * 医疗个人比例
	 */
    @ApiModelProperty("医疗个人比例")
	private BigDecimal medicalPersonalRatio;
	/**
	 * 医疗个人
	 */
    @ApiModelProperty("医疗个人")
	private BigDecimal medicalIndividual;
	/**
	 * 工伤企业基数
	 */
    @ApiModelProperty("工伤企业基数")
	private BigDecimal baseOfIndustrialInjuryEnterprises;
	/**
	 * 工伤企业比例
	 */
    @ApiModelProperty("工伤企业比例")
	private BigDecimal proportionOfIndustrialInjuryEnterprises;
	/**
	 * 工伤企业
	 */
    @ApiModelProperty("工伤企业")
	private BigDecimal industrialInjuryEnterprise;
	/**
	 * 生育企业基数
	 */
    @ApiModelProperty("生育企业基数")
	private BigDecimal fertilityEnterpriseBase;
	/**
	 * 生育企业比例
	 */
    @ApiModelProperty("生育企业比例")
	private BigDecimal proportionOfFertilityEnterprises;
	/**
	 * 生育企业
	 */
    @ApiModelProperty("生育企业")
	private BigDecimal childbearingEnterprise;
	/**
	 * 大病企业基数
	 */
    @ApiModelProperty("大病企业基数")
	private BigDecimal baseOfSeriousIllness;
	/**
	 * 大病企业比例
	 */
    @ApiModelProperty("大病企业比例")
	private BigDecimal proportionOfSeriouslyIllEnterprises;
	/**
	 * 大病企业
	 */
    @ApiModelProperty("大病企业")
	private BigDecimal bigDiseaseEnterprise;
	/**
	 * 大病个人基数
	 */
    @ApiModelProperty("大病个人基数")
	private BigDecimal personalBaseOfSeriousIllness;
	/**
	 * 大病个人比例
	 */
    @ApiModelProperty("大病个人比例")
	private BigDecimal personalProportionOfSeriousIllness;
	/**
	 * 大病个人
	 */
    @ApiModelProperty("大病个人")
	private BigDecimal aPersonOfGreatDisease;
	/**
	 * 公积金备注
	 */
    @ApiModelProperty("公积金备注")
	private String providentFundNotes;
	/**
	 * 社保备注
	 */
    @ApiModelProperty("社保备注")
	private String socialSecurityNotes;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String yearsMonth;

}
