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
 * 扣款类型表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("扣款类型表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_deduction_type")
public class AtteDeductionTypeEntity extends Model<AtteDeductionTypeEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 扣款类型编码
	 */
    @ApiModelProperty(value = "扣款类型编码",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String code;
	/**
	 * 扣款类型编码说明
	 */
    @ApiModelProperty(value = "扣款类型编码说明",example="")
	private String description;
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
