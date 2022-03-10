package com.xiaozheng.model.em;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@ApiModel("")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_user_company_jobs")
public class EmUserCompanyJobsEntity extends Model<EmUserCompanyJobsEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 员工ID
	 */
    @ApiModelProperty("员工ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 企业ID
	 */
    @ApiModelProperty("企业ID")
	private String companyId;
	/**
	 * 岗位
	 */
    @ApiModelProperty("岗位")
	private String post;
	/**
	 * 工作邮箱
	 */
    @ApiModelProperty("工作邮箱")
	private String workMailbox;
	/**
	 * 职级
	 */
    @ApiModelProperty("职级")
	private String rank;
	/**
	 * 转正评价
	 */
    @ApiModelProperty("转正评价")
	private String correctionEvaluation;
	/**
	 * 汇报对象
	 */
    @ApiModelProperty("汇报对象")
	private String reportId;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String reportName;
	/**
	 * 转正状态
	 */
    @ApiModelProperty("转正状态")
	private String stateOfCorrection;
	/**
	 * hrbp
	 */
    @ApiModelProperty("hrbp")
	private String hrbp;
	/**
	 * 首次参加工作时间
	 */
    @ApiModelProperty("首次参加工作时间")
	private String workingTimeForTheFirstTime;
	/**
	 * 调整司龄天
	 */
    @ApiModelProperty("调整司龄天")
	private Integer adjustmentAgedays;
	/**
	 * 调整工龄天
	 */
    @ApiModelProperty("调整工龄天")
	private Integer adjustmentOfLengthOfService;
	/**
	 * 工作城市
	 */
    @ApiModelProperty("工作城市")
	private String workingCity;
	/**
	 * 纳税城市
	 */
    @ApiModelProperty("纳税城市")
	private String taxableCity;
	/**
	 * 现合同开始时间
	 */
    @ApiModelProperty("现合同开始时间")
	private String currentContractStartTime;
	/**
	 * 现合同结束时间
	 */
    @ApiModelProperty("现合同结束时间")
	private String closingTimeOfCurrentContract;
	/**
	 * 首次合同开始时间
	 */
    @ApiModelProperty("首次合同开始时间")
	private String initialContractStartTime;
	/**
	 * 首次合同结束时间
	 */
    @ApiModelProperty("首次合同结束时间")
	private String firstContractTerminationTime;
	/**
	 * 合同期限
	 */
    @ApiModelProperty("合同期限")
	private String contractPeriod;
	/**
	 * 合同文件
	 */
    @ApiModelProperty("合同文件")
	private String contractDocuments;
	/**
	 * 续签次数
	 */
    @ApiModelProperty("续签次数")
	private Integer renewalNumber;
	/**
	 * 其他招聘渠道
	 */
    @ApiModelProperty("其他招聘渠道")
	private String otherRecruitmentChannels;
	/**
	 * 招聘渠道
	 */
    @ApiModelProperty("招聘渠道")
	private String recruitmentChannels;
	/**
	 * 社招校招
	 */
    @ApiModelProperty("社招校招")
	private String socialRecruitment;
	/**
	 * 推荐企业人
	 */
    @ApiModelProperty("推荐企业人")
	private String recommenderBusinessPeople;

}
