package com.xiaozheng.model.em;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
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
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@ApiModel("员工公司表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_user_company")
public class EmUserCompanyEntity extends Model<EmUserCompanyEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
    @ApiModelProperty("用户ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 企业ID
	 */
    @ApiModelProperty("企业ID")
	private String companyId;
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
	private String formOfEmployment;
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
	 * 启用状态
	 */
    @ApiModelProperty("启用状态")
	private Integer state;

}
