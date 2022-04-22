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
 * 流程 拓展表  -- 业务流程实例表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@ApiModel("流程 拓展表  -- 业务流程实例表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("proc_instance")
public class ProcInstanceEntity extends Model<ProcInstanceEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 流程实例ID
	 */
    @ApiModelProperty(value = "流程实例ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String processId;
	/**
	 * 流程标识
	 */
    @ApiModelProperty(value = "流程标识",example="")
	private String processKey;
	/**
	 * 流程名称
	 */
    @ApiModelProperty(value = "流程名称",example="")
	private String processName;
	/**
	 * 流程定义ID
	 */
    @ApiModelProperty(value = "流程定义ID",example="")
	private String processDefinitionId;
	/**
	 * 流程状态（0已提交；1审批中；2审批通过；3审批不通过；4撤销）
	 */
    @ApiModelProperty(value = "流程状态（0已提交；1审批中；2审批通过；3审批不通过；4撤销）",example="")
	private String processState;
	/**
	 * 申请人ID
	 */
    @ApiModelProperty(value = "申请人ID",example="")
	private String userId;
	/**
	 * 申请人
	 */
    @ApiModelProperty(value = "申请人",example="")
	private String username;
	/**
	 * 申请时间
	 */
    @ApiModelProperty(value = "申请时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date procApplyTime;
	/**
	 * 当前节点审批人ID
	 */
    @ApiModelProperty(value = "当前节点审批人ID",example="")
	private String procCurrNodeUserId;
	/**
	 * 当前节点审批人
	 */
    @ApiModelProperty(value = "当前节点审批人",example="")
	private String procCurrNodeUserName;
	/**
	 * 结束流程时间
	 */
    @ApiModelProperty(value = "结束流程时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date procEndTime;
	/**
	 * 申请的业务数据，请假：开始，结束，原因，天数；离职：离职原因 等  数据格式为JSON
	 */
    @ApiModelProperty(value = "申请的业务数据，请假：开始，结束，原因，天数；离职：离职原因 等  数据格式为JSON",example="")
	private String procData;
	/**
	 * 部门ID
	 */
    @ApiModelProperty(value = "部门ID",example="")
	private String departmentId;
	/**
	 * 部门名称
	 */
    @ApiModelProperty(value = "部门名称",example="")
	private String departmentName;
	/**
	 * 入职时间
	 */
    @ApiModelProperty(value = "入职时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date timeOfEntry;

	/**
	 * 更新时间
	 */
	@ApiModelProperty(value = "更新时间", example = "")
	@JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	@TableField(fill = FieldFill.INSERT_UPDATE)
	private Date updateDate;
}
