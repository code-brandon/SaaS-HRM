package com.xiaozheng.model.sa;

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
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@ApiModel("")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_user_salary_change")
public class SaUserSalaryChangeEntity extends Model<SaUserSalaryChangeEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 用户id
	 */
    @ApiModelProperty(value = "用户id",example="")
	private String userId;
	/**
	 * 调整前基本工资
	 */
    @ApiModelProperty(value = "调整前基本工资",example="")
	private BigDecimal currentBasicSalary;
	/**
	 * 调整前岗位工资
	 */
    @ApiModelProperty(value = "调整前岗位工资",example="")
	private BigDecimal currentPostWage;
	/**
	 * 调整基本工资
	 */
    @ApiModelProperty(value = "调整基本工资",example="")
	private BigDecimal adjustmentOfBasicWages;
	/**
	 * 调整岗位工资
	 */
    @ApiModelProperty(value = "调整岗位工资",example="")
	private BigDecimal adjustPostWages;
	/**
	 * 调薪生效时间
	 */
    @ApiModelProperty(value = "调薪生效时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date effectiveTimeOfPayAdjustment;
	/**
	 * 调薪原因
	 */
    @ApiModelProperty(value = "调薪原因",example="")
	private String causeOfSalaryAdjustment;
	/**
	 * 附件
	 */
    @ApiModelProperty(value = "附件",example="")
	private String enclosure;

}
