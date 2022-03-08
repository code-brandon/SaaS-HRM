package com.xiaozheng.model.pe;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@ApiModel("权限表-主表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("pe_permission")
public class PePermissionEntity extends Model<PePermissionEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ApiModelProperty("主键")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 权限描述
     */
    @ApiModelProperty("权限描述")
    private String description;
    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;
    /**
     * 权限类型 1为菜单 2为功能 3为API
     */
    @ApiModelProperty("权限类型 1为菜单 2为功能 3为API")
    private Integer type;
    /**
     * 主键
     */
    @ApiModelProperty("主键")
    private String pid;
    /**
     *编码
     */
    @ApiModelProperty("编码")
    private String code;
    /**
     * 企业可见性 0：不可见，1：可见
     */
    @ApiModelProperty("企业可见性 0：不可见，1：可见")
    private Integer enVisible;

}
