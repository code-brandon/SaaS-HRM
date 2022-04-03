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
 * 考勤归档信息表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("考勤归档信息表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_archive_monthly")
public class AtteArchiveMonthlyEntity extends Model<AtteArchiveMonthlyEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private Long id;
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
	 * 归档年份
	 */
    @ApiModelProperty(value = "归档年份",example="")
	private String archiveYear;
	/**
	 * 归档月份
	 */
    @ApiModelProperty(value = "归档月份",example="")
	private String archiveMonth;
	/**
	 * 总人数
	 */
    @ApiModelProperty(value = "总人数",example="")
	private Integer totalPeopleNum;
	/**
	 * 全勤人数
	 */
    @ApiModelProperty(value = "全勤人数",example="")
	private Integer fullAttePeopleNum;
	/**
	 * 是否归档(0已经归档1没有归档)
	 */
    @ApiModelProperty(value = "是否归档(0已经归档1没有归档)",example="")
	private Integer isArchived;
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

}
