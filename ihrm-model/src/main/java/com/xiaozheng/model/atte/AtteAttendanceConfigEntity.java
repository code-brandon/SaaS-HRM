package com.xiaozheng.model.atte;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 考勤配置表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("考勤配置表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_attendance_config")
public class AtteAttendanceConfigEntity extends Model<AtteAttendanceConfigEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
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
	 * 上午打卡时间
	 */
	@ApiModelProperty(value = "上午打卡时间", example = "")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat(pattern = "HH:mm")
	private String morningStartTime;
	/**
	 * 上午打卡时间
	 */
	@ApiModelProperty(value = "上午打卡时间", example = "")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat(pattern = "HH:mm")
	private String morningEndTime;
	/**
	 * 下午打卡时间
	 */
	@ApiModelProperty(value = "下午打卡时间", example = "")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat(pattern = "HH:mm")
	private String afternoonStartTime;
	/**
	 * 下午打卡时间
	 */
	@ApiModelProperty(value = "下午打卡时间", example = "")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="HH:mm")
	@DateTimeFormat(pattern = "HH:mm")
	private String afternoonEndTime;
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

}
