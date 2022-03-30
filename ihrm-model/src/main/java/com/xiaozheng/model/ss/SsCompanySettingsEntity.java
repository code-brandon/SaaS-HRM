package com.xiaozheng.model.ss;

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
 * 社保-企业设置信息
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
@ApiModel("社保-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("ss_company_settings")
public class SsCompanySettingsEntity extends Model<SsCompanySettingsEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
    @ApiModelProperty("企业id")
	@TableId(type = IdType.ASSIGN_ID)
	private String companyId;
	/**
	 * 0是未设置，1是已设置
	 */
    @ApiModelProperty("0是未设置，1是已设置")
	private Integer isSettings;
	/**
	 * 当前显示报表月份
	 */
    @ApiModelProperty("当前显示报表月份")
	private String dataMonth;

}
