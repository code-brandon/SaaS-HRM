package com.xiaozheng.model.vo.pe;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.vo.pe
 * @ClassName: PeUsetVo
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/6 17:48
 */
@ApiModel("用户登录实体类")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PeUsetVo implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
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
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
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
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
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
}
