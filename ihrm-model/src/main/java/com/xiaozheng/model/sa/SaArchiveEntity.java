package com.xiaozheng.model.sa;

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
 * 工资-归档表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:51
 */
@ApiModel("工资-归档表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_archive")
public class SaArchiveEntity extends Model<SaArchiveEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 企业id
	 */
    @ApiModelProperty(value = "企业id",example="")
	private String companyId;
	/**
	 * 年月
	 */
    @ApiModelProperty(value = "年月",example="")
	private String yearsMonth;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField(fill = FieldFill.INSERT)
	private Date creationTime;
	/**
	 * 人工成本
	 */
    @ApiModelProperty(value = "人工成本",example="")
	private BigDecimal artificialCost;
	/**
	 * 税前工资
	 */
    @ApiModelProperty(value = "税前工资",example="")
	private BigDecimal grossSalary;
	/**
	 * 五险一金
	 */
    @ApiModelProperty(value = "五险一金",example="")
	private BigDecimal fiveInsurances;

}
