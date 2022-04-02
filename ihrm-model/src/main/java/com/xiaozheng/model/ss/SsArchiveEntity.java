package com.xiaozheng.model.ss;

import com.baomidou.mybatisplus.annotation.*;

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
 * 社保-归档表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@ApiModel("社保-归档表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ss_archive")
public class SsArchiveEntity extends Model<SsArchiveEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty("id")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 企业id
	 */
    @ApiModelProperty("企业id")
	private String companyId;
	/**
	 * 年月
	 */
    @ApiModelProperty("年月")
	private String yearsMonth;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date creationTime;
	/**
	 * 企业缴纳
	 */
    @ApiModelProperty("企业缴纳")
	private BigDecimal enterprisePayment;
	/**
	 * 个人缴纳
	 */
    @ApiModelProperty("个人缴纳")
	private BigDecimal personalPayment;
	/**
	 * 合计
	 */
    @ApiModelProperty("合计")
	private BigDecimal total;

}
