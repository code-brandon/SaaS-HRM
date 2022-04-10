package com.xiaozheng.model.atte;

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
 * 考勤-企业设置信息
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@ApiModel("考勤-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("atte_company_settings")
public class AtteCompanySettingsEntity extends Model<AtteCompanySettingsEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 企业id
	 */
    @ApiModelProperty(value = "企业id",example="")
	@TableId(type = IdType.INPUT)
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
