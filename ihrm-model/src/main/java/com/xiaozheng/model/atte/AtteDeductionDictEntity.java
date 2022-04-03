package com.xiaozheng.model.atte;

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
 * 扣款字典表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("扣款字典表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_deduction_dict")
public class AtteDeductionDictEntity extends Model<AtteDeductionDictEntity> implements Serializable {
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
	 * 扣款类型编码
	 */
    @ApiModelProperty(value = "扣款类型编码",example="")
	private String dedTypeCode;
	/**
	 * 时间段下限
	 */
    @ApiModelProperty(value = "时间段下限",example="")
	private String periodLowerLimit;
	/**
	 * 时间段上限
	 */
    @ApiModelProperty(value = "时间段上限",example="")
	private String periodUpperLimit;
	/**
	 * 次数下限
	 */
    @ApiModelProperty(value = "次数下限",example="")
	private String timesLowerLimit;
	/**
	 * 次数上限
	 */
    @ApiModelProperty(value = "次数上限",example="")
	private String timesUpperLimit;
	/**
	 * 扣款金额下限
	 */
    @ApiModelProperty(value = "扣款金额下限",example="")
	private BigDecimal dedAmonutLowerLimit;
	/**
	 * 扣款金额上限
	 */
    @ApiModelProperty(value = "扣款金额上限",example="")
	private BigDecimal dedAmonutUpperLimit;
	/**
	 * 旷工次数上限
	 */
    @ApiModelProperty(value = "旷工次数上限",example="")
	private String absenceTimesUpperLimt;
	/**
	 * 旷工天数
	 */
    @ApiModelProperty(value = "旷工天数",example="")
	private String absenceDays;
	/**
	 * 罚款工资倍数
	 */
    @ApiModelProperty(value = "罚款工资倍数",example="")
	private String fineSalaryMultiples;
	/**
	 * 是否旷工0不旷工1旷工
	 */
    @ApiModelProperty(value = "是否旷工0不旷工1旷工",example="")
	private String isAbsenteeism;
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
