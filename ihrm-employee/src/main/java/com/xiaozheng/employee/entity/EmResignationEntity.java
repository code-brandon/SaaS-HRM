package com.xiaozheng.employee.entity;

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
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@ApiModel("")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_resignation")
public class EmResignationEntity extends Model<EmResignationEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
    @ApiModelProperty("用户ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String resignationTime;
	/**
	 * 离职类型
	 */
    @ApiModelProperty("离职类型")
	private String typeOfTurnover;
	/**
	 * 申请离职原因
	 */
    @ApiModelProperty("申请离职原因")
	private String reasonsForLeaving;
	/**
	 * 补偿金
	 */
    @ApiModelProperty("补偿金")
	private String compensation;
	/**
	 * 代通知金
	 */
    @ApiModelProperty("代通知金")
	private String notifications;
	/**
	 * 社保减员月
	 */
    @ApiModelProperty("社保减员月")
	private String socialSecurityReductionMonth;
	/**
	 * 公积金减员月
	 */
    @ApiModelProperty("公积金减员月")
	private String providentFundReductionMonth;
	/**
	 * 图片
	 */
    @ApiModelProperty("图片")
	private String picture;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

}
