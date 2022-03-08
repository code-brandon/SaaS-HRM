package com.xiaozheng.model.pe;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@ApiModel("用户表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("pe_user")
public class PeUserEntity extends Model<PeUserEntity> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @ApiModelProperty("ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String username;
    /**
     * 密码
     */
    @JsonProperty(access= JsonProperty.Access.WRITE_ONLY)
    @ApiModelProperty("密码")
    private String password;
    /**
     * 角色
     */
    @ApiModelProperty("角色")
    private String role;
    /**
     * 启用状态 0是禁用，1是启用
     */
    @ApiModelProperty("启用状态 0是禁用，1是启用")
    private Integer enableState;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @TableField( fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 部门ID
     */
    @ApiModelProperty("部门ID")
    private String departmentId;
    /**
     * 入职时间
     */
    @ApiModelProperty("入职时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date timeOfEntry;
    /**
     * 聘用形式
     */
    @ApiModelProperty("聘用形式")
    private Integer formOfEmployment;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private String workNumber;
    /**
     * 管理形式
     */
    @ApiModelProperty("管理形式")
    private String formOfManagement;
    /**
     * 工作城市
     */
    @ApiModelProperty("工作城市")
    private String workingCity;
    /**
     * 转正时间
     */
    @ApiModelProperty("转正时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date correctionTime;
    /**
     * 在职状态 1.在职  2.离职
     */
    @ApiModelProperty("在职状态 1.在职  2.离职")
    private Integer inServiceStatus;
    /**
     * 企业ID
     */
    @ApiModelProperty("企业ID")
    private String companyId;
    /**
     * 公司名
     */
    @ApiModelProperty("公司名")
    private String companyName;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String departmentName;
    /**
     * 角色 ID
     */
    @ApiModelProperty("角色 ID")
    private String roleIds;
    /**
     * 用户类型
     */
    @ApiModelProperty("用户类型")
    private String level;

}
