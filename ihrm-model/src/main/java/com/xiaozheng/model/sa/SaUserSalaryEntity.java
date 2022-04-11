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
 * 工资-员工薪资表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@ApiModel("工资-员工薪资表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_user_salary")
public class SaUserSalaryEntity extends Model<SaUserSalaryEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @ApiModelProperty(value = "",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 当前基本工资
	 */
    @ApiModelProperty(value = "当前基本工资",example="")
	private BigDecimal currentBasicSalary;
	/**
	 * 当前岗位工资
	 */
    @ApiModelProperty(value = "当前岗位工资",example="")
	private BigDecimal currentPostWage;
	/**
	 * 定薪基本工资
	 */
    @ApiModelProperty(value = "定薪基本工资",example="")
	private BigDecimal fixedBasicSalary;
	/**
	 * 定薪岗位工资
	 */
    @ApiModelProperty(value = "定薪岗位工资",example="")
	private BigDecimal fixedPostWage;
	/**
	 * 转正基本工资
	 */
    @ApiModelProperty(value = "转正基本工资",example="")
	private BigDecimal correctionOfBasicWages;
	/**
	 * 转正岗位工资
	 */
    @ApiModelProperty(value = "转正岗位工资",example="")
	private BigDecimal turnToPostWages;

}
