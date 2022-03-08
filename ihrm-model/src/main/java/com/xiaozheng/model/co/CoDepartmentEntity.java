package com.xiaozheng.model.co;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@ApiModel("联合部门")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("co_department")
public class CoDepartmentEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 企业ID
     */
    @ApiModelProperty("企业ID")
    private String companyId;
    /**
     * 父级部门ID
     */
    @ApiModelProperty("父级部门ID")
    private String pid;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String name;
    /**
     * 部门编码
     */
    @ApiModelProperty("部门编码")
    private String code;
    /**
     * 部门负责人
     */
    @ApiModelProperty("部门负责人")
    private String manager;
    /**
     * 介绍
     */
    @ApiModelProperty("介绍")
    private String introduce;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 负责人ID
     */
    @ApiModelProperty("负责人ID")
    private String managerId;

}
