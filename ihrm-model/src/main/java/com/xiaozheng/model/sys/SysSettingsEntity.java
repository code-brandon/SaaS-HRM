package com.xiaozheng.model.sys;

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
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@ApiModel("系统设置")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_settings")
public class SysSettingsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 企业ID
     */
    @ApiModelProperty("企业ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String companyId;
    /**
     * 设置类型
     */
    @ApiModelProperty("设置类型")
    private Integer settingsType;
    /**
     * 详细设置
     */
    @ApiModelProperty("详细设置")
    private String settingsInfo;

}
