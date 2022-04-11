package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 工资-企业设置信息
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@ApiModel("工资-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("sa_company_settings")
public class SaCompanySettingsEntity extends Model<SaCompanySettingsEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
    @ApiModelProperty(value = "企业id",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String companyId;
	/**
	 * 0是未设置，1是已设置
	 */
    @ApiModelProperty(value = "0是未设置，1是已设置",example="")
	private Integer isSettings;
	/**
	 * 当前显示报表月份
	 */
    @ApiModelProperty(value = "当前显示报表月份",example="")
	private String dataMonth;

}
