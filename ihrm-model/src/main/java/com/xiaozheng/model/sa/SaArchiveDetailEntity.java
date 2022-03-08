package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * 工资-归档详情
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("工资-归档详情")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_archive_detail")
public class SaArchiveDetailEntity implements Serializable {
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
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String username;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private String workNumber;
    /**
     * 部门
     */
    @ApiModelProperty("部门")
    private String departmentName;
    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String idNumber;
    /**
     * 在职状态
     */
    @ApiModelProperty("在职状态")
    private String inServiceStatus;
    /**
     * 聘用形式
     */
    @ApiModelProperty("聘用形式")
    private String formOfEmployment;
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    private String bankCardNumber;
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    private String openingBank;
    /**
     * 公积金个人
     */
    @ApiModelProperty("公积金个人")
    private BigDecimal providentFundIndividual;
    /**
     * 社保个人
     */
    @ApiModelProperty("社保个人")
    private BigDecimal socialSecurityIndividual;
    /**
     * 养老个人
     */
    @ApiModelProperty("养老个人")
    private BigDecimal oldAgeIndividual;
    /**
     * 医疗个人
     */
    @ApiModelProperty("医疗个人")
    private BigDecimal medicalIndividual;
    /**
     * 失业个人
     */
    @ApiModelProperty("失业个人")
    private BigDecimal unemployedIndividual;
    /**
     * 大病个人
     */
    @ApiModelProperty("大病个人")
    @TableField(value = "a_person_of_great_disease")
    private BigDecimal aPersonOfGreatDisease;
    /**
     * 社保扣款
     */
    @ApiModelProperty("社保扣款")
    private BigDecimal socialSecurity;
    /**
     * 公积金扣款
     */
    @ApiModelProperty("公积金扣款")
    private BigDecimal totalProvidentFundIndividual;
    /**
     * 社保企业
     */
    @ApiModelProperty("社保企业")
    private BigDecimal socialSecurityEnterprise;
    /**
     * 养老企业
     */
    @ApiModelProperty("养老企业")
    private BigDecimal pensionEnterprise;
    /**
     * 医疗企业
     */
    @ApiModelProperty("医疗企业")
    private BigDecimal medicalEnterprise;
    /**
     * 失业企业
     */
    @ApiModelProperty("失业企业")
    private BigDecimal unemployedEnterprise;
    /**
     * 工伤企业
     */
    @ApiModelProperty("工伤企业")
    private BigDecimal industrialInjuryEnterprise;
    /**
     * 生育企业
     */
    @ApiModelProperty("生育企业")
    private BigDecimal childbearingEnterprise;
    /**
     * 大病企业
     */
    @ApiModelProperty("大病企业")
    private BigDecimal bigDiseaseEnterprise;
    /**
     * 公积金企业
     */
    @ApiModelProperty("公积金企业")
    private BigDecimal providentFundEnterprises;
    /**
     * 公积金社保企业
     */
    @ApiModelProperty("公积金社保企业")
    private BigDecimal socialSecurityProvidentFundEnterprises;
    /**
     * 公积金需纳税额
     */
    @ApiModelProperty("公积金需纳税额")
    private BigDecimal taxToProvidentFund;
    /**
     * 计薪天数
     */
    @ApiModelProperty("计薪天数")
    private BigDecimal officialSalaryDays;
    /**
     * 考勤扣款
     */
    @ApiModelProperty("考勤扣款")
    private BigDecimal attendanceDeductionMonthly;
    /**
     * 计薪标准
     */
    @ApiModelProperty("计薪标准")
    private BigDecimal salaryStandard;
    /**
     * 最新工资基数合计
     */
    @ApiModelProperty("最新工资基数合计")
    private BigDecimal currentSalaryTotalBase;
    /**
     * 最新基本工资基数
     */
    @ApiModelProperty("最新基本工资基数")
    private BigDecimal currentBaseSalary;
    /**
     * 当月基本工资基数
     */
    @ApiModelProperty("当月基本工资基数")
    private BigDecimal baseSalaryByMonth;
    /**
     * 计税方式
     */
    @ApiModelProperty("计税方式")
    private String taxCountingMethod;
    /**
     * 当月纳税基本工资
     */
    @ApiModelProperty("当月纳税基本工资")
    private BigDecimal baseSalaryToTaxByMonth;
    /**
     * 税前工资合计
     */
    @ApiModelProperty("税前工资合计")
    private BigDecimal salaryBeforeTax;
    /**
     * 工资合计
     */
    @ApiModelProperty("工资合计")
    private BigDecimal salary;
    /**
     * 应纳税工资
     */
    @ApiModelProperty("应纳税工资")
    private BigDecimal salaryByTax;
    /**
     * 税前实发
     */
    @ApiModelProperty("税前实发")
    private BigDecimal paymentBeforeTax;
    /**
     * 应扣税
     */
    @ApiModelProperty("应扣税")
    private BigDecimal tax;
    /**
     * 税后工资合计
     */
    @ApiModelProperty("税后工资合计")
    private BigDecimal salaryAfterTax;
    /**
     * 实发工资
     */
    @ApiModelProperty("实发工资")
    private BigDecimal payment;
    /**
     * 实发工资备注
     */
    @ApiModelProperty("实发工资备注")
    private String paymentRemark;
    /**
     * 薪酬成本
     */
    @ApiModelProperty("薪酬成本")
    private BigDecimal salaryCost;
    /**
     * 企业人工成本
     */
    @ApiModelProperty("企业人工成本")
    private BigDecimal enterpriseLaborCost;
    /**
     * 调薪金额
     */
    @ApiModelProperty("调薪金额")
    private BigDecimal salaryChangeAmount;
    /**
     * 调薪比例
     */
    @ApiModelProperty("调薪比例")
    private BigDecimal salaryChangeScale;
    /**
     * 调薪生效时间
     */
    @ApiModelProperty("调薪生效时间")
    private BigDecimal effectiveTimeOfPayAdjustment;
    /**
     * 调薪原因
     */
    @ApiModelProperty("调薪原因")
    private BigDecimal causeOfSalaryAdjustment;
    /**
     * 注释
     */
    @ApiModelProperty("注释")
    private String remark;
    /**
     * 发薪月数
     */
    @ApiModelProperty("发薪月数")
    private Integer paymentMonths;

}
