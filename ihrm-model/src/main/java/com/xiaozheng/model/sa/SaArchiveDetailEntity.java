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
 * 工资-归档详情
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@ApiModel("工资-归档详情")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_archive_detail")
public class SaArchiveDetailEntity extends Model<SaArchiveDetailEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 归档id
	 */
    @ApiModelProperty(value = "归档id",example="")
	private String archiveId;
	/**
	 * 用户id
	 */
    @ApiModelProperty(value = "用户id",example="")
	private String userId;
	/**
	 * 姓名
	 */
    @ApiModelProperty(value = "姓名",example="")
	private String username;
	/**
	 * 手机号
	 */
    @ApiModelProperty(value = "手机号",example="")
	private String mobile;
	/**
	 * 工号
	 */
    @ApiModelProperty(value = "工号",example="")
	private String workNumber;
	/**
	 * 部门
	 */
    @ApiModelProperty(value = "部门",example="")
	private String departmentName;
	/**
	 * 身份证号
	 */
    @ApiModelProperty(value = "身份证号",example="")
	private String idNumber;
	/**
	 * 在职状态
	 */
    @ApiModelProperty(value = "在职状态",example="")
	private String inServiceStatus;
	/**
	 * 聘用形式
	 */
    @ApiModelProperty(value = "聘用形式",example="")
	private String formOfEmployment;
	/**
	 * 银行卡号
	 */
    @ApiModelProperty(value = "银行卡号",example="")
	private String bankCardNumber;
	/**
	 * 银行卡号
	 */
    @ApiModelProperty(value = "银行卡号",example="")
	private String openingBank;
	/**
	 * 公积金个人
	 */
    @ApiModelProperty(value = "公积金个人",example="")
	private BigDecimal providentFundIndividual;
	/**
	 * 社保个人
	 */
    @ApiModelProperty(value = "社保个人",example="")
	private BigDecimal socialSecurityIndividual;
	/**
	 * 养老个人
	 */
    @ApiModelProperty(value = "养老个人",example="")
	private BigDecimal oldAgeIndividual;
	/**
	 * 医疗个人
	 */
    @ApiModelProperty(value = "医疗个人",example="")
	private BigDecimal medicalIndividual;
	/**
	 * 失业个人
	 */
    @ApiModelProperty(value = "失业个人",example="")
	private BigDecimal unemployedIndividual;
	/**
	 * 大病个人
	 */
    @ApiModelProperty(value = "大病个人",example="")
	private BigDecimal aPersonOfGreatDisease;
	/**
	 * 社保扣款
	 */
    @ApiModelProperty(value = "社保扣款",example="")
	private BigDecimal socialSecurity;
	/**
	 * 公积金扣款
	 */
    @ApiModelProperty(value = "公积金扣款",example="")
	private BigDecimal totalProvidentFundIndividual;
	/**
	 * 社保企业
	 */
    @ApiModelProperty(value = "社保企业",example="")
	private BigDecimal socialSecurityEnterprise;
	/**
	 * 养老企业
	 */
    @ApiModelProperty(value = "养老企业",example="")
	private BigDecimal pensionEnterprise;
	/**
	 * 医疗企业
	 */
    @ApiModelProperty(value = "医疗企业",example="")
	private BigDecimal medicalEnterprise;
	/**
	 * 失业企业
	 */
    @ApiModelProperty(value = "失业企业",example="")
	private BigDecimal unemployedEnterprise;
	/**
	 * 工伤企业
	 */
    @ApiModelProperty(value = "工伤企业",example="")
	private BigDecimal industrialInjuryEnterprise;
	/**
	 * 生育企业
	 */
    @ApiModelProperty(value = "生育企业",example="")
	private BigDecimal childbearingEnterprise;
	/**
	 * 大病企业
	 */
    @ApiModelProperty(value = "大病企业",example="")
	private BigDecimal bigDiseaseEnterprise;
	/**
	 * 公积金企业
	 */
    @ApiModelProperty(value = "公积金企业",example="")
	private BigDecimal providentFundEnterprises;
	/**
	 * 公积金社保企业
	 */
    @ApiModelProperty(value = "公积金社保企业",example="")
	private BigDecimal socialSecurityProvidentFundEnterprises;
	/**
	 * 公积金需纳税额
	 */
    @ApiModelProperty(value = "公积金需纳税额",example="")
	private BigDecimal taxToProvidentFund;
	/**
	 * 计薪天数
	 */
    @ApiModelProperty(value = "计薪天数",example="")
	private BigDecimal officialSalaryDays;
	/**
	 * 考勤扣款
	 */
    @ApiModelProperty(value = "考勤扣款",example="")
	private BigDecimal attendanceDeductionMonthly;
	/**
	 * 计薪标准
	 */
    @ApiModelProperty(value = "计薪标准",example="")
	private BigDecimal salaryStandard;
	/**
	 * 最新工资基数合计
	 */
    @ApiModelProperty(value = "最新工资基数合计",example="")
	private BigDecimal currentSalaryTotalBase;
	/**
	 * 最新基本工资基数
	 */
    @ApiModelProperty(value = "最新基本工资基数",example="")
	private BigDecimal currentBaseSalary;
	/**
	 * 当月基本工资基数
	 */
    @ApiModelProperty(value = "当月基本工资基数",example="")
	private BigDecimal baseSalaryByMonth;
	/**
	 * 计税方式
	 */
    @ApiModelProperty(value = "计税方式",example="")
	private String taxCountingMethod;
	/**
	 * 当月纳税基本工资
	 */
    @ApiModelProperty(value = "当月纳税基本工资",example="")
	private BigDecimal baseSalaryToTaxByMonth;
	/**
	 * 税前工资合计
	 */
    @ApiModelProperty(value = "税前工资合计",example="")
	private BigDecimal salaryBeforeTax;
	/**
	 * 工资合计
	 */
    @ApiModelProperty(value = "工资合计",example="")
	private BigDecimal salary;
	/**
	 * 应纳税工资
	 */
    @ApiModelProperty(value = "应纳税工资",example="")
	private BigDecimal salaryByTax;
	/**
	 * 税前实发
	 */
    @ApiModelProperty(value = "税前实发",example="")
	private BigDecimal paymentBeforeTax;
	/**
	 * 应扣税
	 */
    @ApiModelProperty(value = "应扣税",example="")
	private BigDecimal tax;
	/**
	 * 税后工资合计
	 */
    @ApiModelProperty(value = "税后工资合计",example="")
	private BigDecimal salaryAfterTax;
	/**
	 * 实发工资
	 */
    @ApiModelProperty(value = "实发工资",example="")
	private BigDecimal payment;
	/**
	 * 实发工资备注
	 */
    @ApiModelProperty(value = "实发工资备注",example="")
	private String paymentRemark;
	/**
	 * 薪酬成本
	 */
    @ApiModelProperty(value = "薪酬成本",example="")
	private BigDecimal salaryCost;
	/**
	 * 企业人工成本
	 */
    @ApiModelProperty(value = "企业人工成本",example="")
	private BigDecimal enterpriseLaborCost;
	/**
	 * 调薪金额
	 */
    @ApiModelProperty(value = "调薪金额",example="")
	private BigDecimal salaryChangeAmount;
	/**
	 * 调薪比例
	 */
    @ApiModelProperty(value = "调薪比例",example="")
	private BigDecimal salaryChangeScale;
	/**
	 * 调薪生效时间
	 */
    @ApiModelProperty(value = "调薪生效时间",example="")
	private BigDecimal effectiveTimeOfPayAdjustment;
	/**
	 * 调薪原因
	 */
    @ApiModelProperty(value = "调薪原因",example="")
	private BigDecimal causeOfSalaryAdjustment;
	/**
	 * 注释
	 */
    @ApiModelProperty(value = "注释",example="")
	private String remark;
	/**
	 * 发薪月数
	 */
    @ApiModelProperty(value = "发薪月数",example="")
	private Integer paymentMonths;

}
