package com.xiaozheng.model.em;

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
@ApiModel("转正申请表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_positive")
public class EmPositiveEntity extends Model<EmPositiveEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 员工ID
	 */
    @ApiModelProperty("员工ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 转正日期
	 */
    @ApiModelProperty("转正日期")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date dateOfCorrection;
	/**
	 * 转正评价
	 */
    @ApiModelProperty("转正评价")
	private String correctionEvaluation;
	/**
	 * 附件
	 */
    @ApiModelProperty("附件")
	private String enclosure;
	/**
	 * 单据状态 1是未执行，2是已执行
	 */
    @ApiModelProperty("单据状态 1是未执行，2是已执行")
	private Integer estatus;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

}
