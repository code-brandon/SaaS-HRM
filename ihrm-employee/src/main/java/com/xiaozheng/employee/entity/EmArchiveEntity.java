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
@TableName("em_archive")
public class EmArchiveEntity extends Model<EmArchiveEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
    @ApiModelProperty("ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 操作用户
	 */
    @ApiModelProperty("操作用户")
	private String opUser;
	/**
	 * 月份
	 */
    @ApiModelProperty("月份")
	private String month;
	/**
	 * 企业ID
	 */
    @ApiModelProperty("企业ID")
	private String companyId;
	/**
	 * 总人数
	 */
    @ApiModelProperty("总人数")
	private Integer totals;
	/**
	 * 在职人数
	 */
    @ApiModelProperty("在职人数")
	private Integer payrolls;
	/**
	 * 离职人数
	 */
    @ApiModelProperty("离职人数")
	private Integer departures;
	/**
	 * 数据
	 */
    @ApiModelProperty("数据")
	private String data;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

}
