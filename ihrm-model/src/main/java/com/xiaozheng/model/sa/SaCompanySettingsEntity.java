package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 工资-企业设置信息
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("工资-企业设置信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_company_settings")
public class SaCompanySettingsEntity implements Serializable {
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
