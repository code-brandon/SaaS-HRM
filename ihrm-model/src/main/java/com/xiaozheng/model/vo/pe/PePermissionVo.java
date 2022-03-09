package com.xiaozheng.model.vo.pe;

import com.xiaozheng.model.pe.PePermissionEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.vo.co
 * @ClassName: CoDepartmentVo
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/5 14:33
 */
@ApiModel("权限表-Vo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PePermissionVo extends PePermissionEntity implements Serializable {
    /**
     * 权限等级，1为通用接口权限，2为需校验接口权限
     */
    @ApiModelProperty("权限等级，1为通用接口权限，2为需校验接口权限")
    private String apiLevel;
    /**
     * 请求类型
     */
    @ApiModelProperty("请求类型")
    private String apiMethod;
    /**
     * 链接
     */
    @ApiModelProperty("链接")
    private String apiUrl;

    /**
     * 权限代码
     */
    @ApiModelProperty("权限代码")
    private String menuIcon;
    /**
     *
     */
    @ApiModelProperty("菜单顺序")
    private String menuOrder;

    /**
     * 按钮类型
     */
    @ApiModelProperty("按钮类型")
    private String pointClass;
    /**
     * 按钮icon
     */
    @ApiModelProperty("按钮icon")
    private String pointIcon;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer pointStatus;
}
