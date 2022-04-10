package com.xiaozheng.model.atte;

import com.baomidou.mybatisplus.annotation.*;

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
 * 考勤表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("考勤表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_attendance")
public class AtteAttendanceEntity extends Model<AtteAttendanceEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 用户ID
	 */
    @ApiModelProperty(value = "用户ID",example="")
	private String userId;
	/**
	 * 公司ID
	 */
    @ApiModelProperty(value = "公司ID",example="")
	private String companyId;
	/**
	 * 部门ID
	 */
    @ApiModelProperty(value = "部门ID",example="")
	private String departmentId;
	/**
	 * 考情状态 1正常2旷工3迟到4早退5外出6出差7年假8事假9病假10婚假11丧假12产假13奖励产假14陪产假15探亲假16工伤假17调休18产检假19流产假20长期病假21测试架22补签23休息
	 */
    @ApiModelProperty(value = "考情状态 1正常2旷工3迟到4早退5外出6出差7年假8事假9病假10婚假11丧假12产假13奖励产假14陪产假15探亲假16工伤假17调休18产检假19流产假20长期病假21测试架22补签23休息",example="")
	private Integer adtStatu;
	/**
	 * 职位状态 1在职2离职
	 */
    @ApiModelProperty(value = "职位状态 1在职2离职",example="")
	private Integer jobStatu;
	/**
	 * 上班考勤时间
	 */
    @ApiModelProperty(value = "上班考勤时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date adtInTime;
	/**
	 * 考勤地点
	 */
    @ApiModelProperty(value = "考勤地点",example="")
	private String adtInPlace;
	/**
	 * 考勤办公室
	 */
    @ApiModelProperty(value = "考勤办公室",example="")
	private String adtInHourse;
	/**
	 * 考勤坐标
	 */
    @ApiModelProperty(value = "考勤坐标",example="")
	private String adtInCoordinate;
	/**
	 * 下班考勤时间
	 */
    @ApiModelProperty(value = "下班考勤时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date adtOutTime;
	/**
	 * 下班考情地点
	 */
    @ApiModelProperty(value = "下班考情地点",example="")
	private String adtOutPlace;
	/**
	 * 考勤办公室
	 */
    @ApiModelProperty(value = "考勤办公室",example="")
	private String adtOutHourse;
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
	@TableField(fill = FieldFill.INSERT)
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
	@TableField(fill = FieldFill.INSERT_UPDATE)
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
	private String username;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String mobile;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String departmentName;
	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	private String day;

}
