package com.xiaozheng.model.proc;

import com.baomidou.mybatisplus.annotation.*;

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
 * 流程 拓展表 -- 业务流程的用户组表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@ApiModel("流程 拓展表 -- 业务流程的用户组表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("proc_user_group")
public class ProcUserGroupEntity extends Model<ProcUserGroupEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
    @ApiModelProperty(value = "主键",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String id;
	/**
	 * 组名
	 */
    @ApiModelProperty(value = "组名",example="")
	private String name;
	/**
	 * 入参
	 */
    @ApiModelProperty(value = "入参",example="")
	private String param;
	/**
	 * 对应sql
	 */
    @ApiModelProperty(value = "对应sql",example="")
	private String isql;
	/**
	 * 有效标记
	 */
    @ApiModelProperty(value = "有效标记",example="")
	private String isvalid;
	/**
	 * 创建人
	 */
    @ApiModelProperty(value = "创建人",example="")
	private String createUser;
	/**
	 * 创建时间
	 */
    @ApiModelProperty(value = "创建时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField(fill = FieldFill.INSERT)
	private Date createTime;
	/**
	 * 最后更新人
	 */
    @ApiModelProperty(value = "最后更新人",example="")
	private String updateUser;
	/**
	 * 最后更新时间
	 */
    @ApiModelProperty(value = "最后更新时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateTime;

}
