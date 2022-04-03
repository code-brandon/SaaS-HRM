package com.xiaozheng.model.atte;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.sql.Time;
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
 * 加班规则
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("加班规则")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_extra_duty_rule")
public class AtteExtraDutyRuleEntity extends Model<AtteExtraDutyRuleEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
    @ApiModelProperty(value = "主键ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 加班配置ID
	 */
    @ApiModelProperty(value = "加班配置ID",example="")
	private String extraDutyConfigId;
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
	 * 规则内容
	 */
    @ApiModelProperty(value = "规则内容",example="")
	private String rule;
	/**
	 * 规则生效每日开始时间
	 */
    @ApiModelProperty(value = "规则生效每日开始时间",example="")
	private Time ruleStartTime;
	/**
	 * 规则生效每日结束时间
	 */
    @ApiModelProperty(value = "规则生效每日结束时间",example="")
	private Time ruleEndTime;
	/**
	 * 是否调休0不调休1调休
	 */
    @ApiModelProperty(value = "是否调休0不调休1调休",example="")
	private String isTimeOff;
	/**
	 * 是否可用 0开启 1 关闭
	 */
    @ApiModelProperty(value = "是否可用 0开启 1 关闭",example="")
	private Integer isEnable;
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
