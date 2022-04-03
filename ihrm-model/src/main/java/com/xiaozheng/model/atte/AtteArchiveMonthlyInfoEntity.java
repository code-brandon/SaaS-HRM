package com.xiaozheng.model.atte;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

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
 * 考勤归档信息详情表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("考勤归档信息详情表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_archive_monthly_info")
public class AtteArchiveMonthlyInfoEntity extends Model<AtteArchiveMonthlyInfoEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 归档id
	 */
    @ApiModelProperty(value = "归档id",example="")
	private Long atteArchiveMonthlyId;
	/**
	 * 姓名
	 */
    @ApiModelProperty(value = "姓名",example="")
	private String name;
	/**
	 * 工号
	 */
    @ApiModelProperty(value = "工号",example="")
	private String workNumber;
	/**
	 * 手机号
	 */
    @ApiModelProperty(value = "手机号",example="")
	private String mobile;
	/**
	 * 当月考勤方案
	 */
    @ApiModelProperty(value = "当月考勤方案",example="")
	private String atteSolution;
	/**
	 * 一级部门
	 */
    @ApiModelProperty(value = "一级部门",example="")
	private String department;
	/**
	 * 工作城市
	 */
    @ApiModelProperty(value = "工作城市",example="")
	private String workCity;
	/**
	 * 年假天数
	 */
    @ApiModelProperty(value = "年假天数",example="")
	private String yearLeaveDays;
	/**
	 * 事假天数
	 */
    @ApiModelProperty(value = "事假天数",example="")
	private String leaveDays;
	/**
	 * 病假天数
	 */
    @ApiModelProperty(value = "病假天数",example="")
	private String sickLeaveDays;
	/**
	 * 长期病假天数
	 */
    @ApiModelProperty(value = "长期病假天数",example="")
	private String longSickLeaveDays;
	/**
	 * 婚假天数
	 */
    @ApiModelProperty(value = "婚假天数",example="")
	private String marraiageLeaveDays;
	/**
	 * 丧假天数
	 */
    @ApiModelProperty(value = "丧假天数",example="")
	private String funeralLeaveDays;
	/**
	 * 产假天数
	 */
    @ApiModelProperty(value = "产假天数",example="")
	private String maternityLeaveDays;
	/**
	 * 奖励产假天数
	 */
    @ApiModelProperty(value = "奖励产假天数",example="")
	private String rewardMaternityLeaveDays;
	/**
	 * 陪产假天数
	 */
    @ApiModelProperty(value = "陪产假天数",example="")
	private String paternityLeaveDays;
	/**
	 * 探亲假天数
	 */
    @ApiModelProperty(value = "探亲假天数",example="")
	private String homeLeavaDays;
	/**
	 * 工伤假
	 */
    @ApiModelProperty(value = "工伤假",example="")
	private String accidentialLeaveDays;
	/**
	 * 调休天数
	 */
    @ApiModelProperty(value = "调休天数",example="")
	private String dayOffLeaveDays;
	/**
	 * 产检假天数
	 */
    @ApiModelProperty(value = "产检假天数",example="")
	private String doctorOffLeaveDays;
	/**
	 * 流产假天数
	 */
    @ApiModelProperty(value = "流产假天数",example="")
	private String abortionLeaveDays;
	/**
	 * 正常天数
	 */
    @ApiModelProperty(value = "正常天数",example="")
	private String normalDays;
	/**
	 * 外出天数
	 */
    @ApiModelProperty(value = "外出天数",example="")
	private String outgoingDays;
	/**
	 * 出差天数
	 */
    @ApiModelProperty(value = "出差天数",example="")
	private String onBusinessDays;
	/**
	 * 迟到次数
	 */
    @ApiModelProperty(value = "迟到次数",example="")
	private Integer laterTimes;
	/**
	 * 早退次数
	 */
    @ApiModelProperty(value = "早退次数",example="")
	private Integer earlyTimes;
	/**
	 * 迟到次数
	 */
    @ApiModelProperty(value = "迟到次数",example="")
	private Integer signedTimes;
	/**
	 * 日均时长（自然日）
	 */
    @ApiModelProperty(value = "日均时长（自然日）",example="")
	private String hoursPerDays;
	/**
	 * 日均时长(工作日)
	 */
    @ApiModelProperty(value = "日均时长(工作日)",example="")
	private String hoursPerWorkDay;
	/**
	 * 日均时长（休息日）
	 */
    @ApiModelProperty(value = "日均时长（休息日）",example="")
	private String hoursPerRestDay;
	/**
	 * 打卡率
	 */
    @ApiModelProperty(value = "打卡率",example="")
	private String clockRate;
	/**
	 * 旷工天数
	 */
    @ApiModelProperty(value = "旷工天数",example="")
	private String absenceDays;
	/**
	 * 是否全勤0全勤1非全勤
	 */
    @ApiModelProperty(value = "是否全勤0全勤1非全勤",example="")
	private String isFullAttendanceint;
	/**
	 * 实际出勤天数（非正式）
	 */
    @ApiModelProperty(value = "实际出勤天数（非正式）",example="")
	private String actualAtteUnofficialDays;
	/**
	 * 实际出勤天数（正式）
	 */
    @ApiModelProperty(value = "实际出勤天数（正式）",example="")
	private String actualAtteOfficialDays;
	/**
	 * 应出勤工作日
	 */
    @ApiModelProperty(value = "应出勤工作日",example="")
	private String workingDays;
	/**
	 * 计薪标准
	 */
    @ApiModelProperty(value = "计薪标准",example="")
	private String salaryStandards;
	/**
	 * 计薪天数调整
	 */
    @ApiModelProperty(value = "计薪天数调整",example="")
	private String salaryAdjustmentDays;
	/**
	 * 工作时长
	 */
    @ApiModelProperty(value = "工作时长",example="")
	private String workHour;
	/**
	 * 计薪天数（非正式）
	 */
    @ApiModelProperty(value = "计薪天数（非正式）",example="")
	private String salaryUnofficialDays;
	/**
	 * 计薪天数（正式）
	 */
    @ApiModelProperty(value = "计薪天数（正式）",example="")
	private String salaryOfficialDays;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String createBy;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createDate;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String updateBy;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date updateDate;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String remarks;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String userId;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String archiveDate;

}
