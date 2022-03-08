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
@ApiModel("权限API表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("pe_permission_api")
public class PePermissionApiEntity extends Model<PePermissionApiEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
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

}
