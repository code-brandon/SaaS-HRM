package com.xiaozheng.model.ss;

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
 * 社保-城市与缴费项目关联表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@ApiModel("社保-城市与缴费项目关联表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ss_city_payment_item")
public class SsCityPaymentItemEntity extends Model<SsCityPaymentItemEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @ApiModelProperty("")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 城市id
	 */
    @ApiModelProperty("城市id")
	private String cityId;
	/**
	 * 缴费项目id
	 */
    @ApiModelProperty("缴费项目id")
	private String paymentItemId;
	/**
	 * 企业是否缴纳开关，0为禁用，1为启用
	 */
    @ApiModelProperty("企业是否缴纳开关，0为禁用，1为启用")
	private Integer switchCompany;
	/**
	 * 企业比例
	 */
    @ApiModelProperty("企业比例")
	private BigDecimal scaleCompany;
	/**
	 * 个人是否缴纳开关，0为禁用，1为启用
	 */
    @ApiModelProperty("个人是否缴纳开关，0为禁用，1为启用")
	private Integer switchPersonal;
	/**
	 * 个人比例
	 */
    @ApiModelProperty("个人比例")
	private BigDecimal scalePersonal;
	/**
	 * 缴费项目名称
	 */
    @ApiModelProperty("缴费项目名称")
	private String name;

}
