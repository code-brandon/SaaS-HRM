package com.xiaozheng.model.bs;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * bs_用户
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@ApiModel("bs_用户")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("bs_user")
public class BsUserEntity extends Model<BsUserEntity> implements Serializable {
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
    @ApiModelProperty("密码")
	private String password;
	/**
	 * 启用状态 0是禁用，1是启用
	 */
    @ApiModelProperty("启用状态 0是禁用，1是启用")
	private Integer enableState;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
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
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
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
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
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
	 * 
	 */
    @ApiModelProperty("")
	private String companyName;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String departmentName;
	/**
	 * 用户级别：saasAdmin，coAdmin，user
	 */
    @ApiModelProperty("用户级别：saasAdmin，coAdmin，user")
	private String level;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String staffPhoto;
	/**
	 * 离职时间
	 */
    @ApiModelProperty("离职时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date timeOfDimission;

}
