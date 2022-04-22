package com.xiaozheng.model.proc;

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
 * 流程 拓展表 -- 业务流程的任务表
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@ApiModel("流程 拓展表 -- 业务流程的任务表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("proc_task_instance")
public class ProcTaskInstanceEntity extends Model<ProcTaskInstanceEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 任务实例ID
	 */
    @ApiModelProperty(value = "任务实例ID",example="")
	@TableId(type = IdType.ASSIGN_ID)
	private String taskId;
	/**
	 * 流程实例ID
	 */
	@ApiModelProperty(value = "流程实例ID",example="")
	private String processId;
	/**
	 * 任务节点key
	 */
    @ApiModelProperty(value = "任务节点key",example="")
	private String taskKey;
	/**
	 * 任务节点
	 */
    @ApiModelProperty(value = "任务节点",example="")
	private String taskName;
	/**
	 * 应审批用户ID
	 */
    @ApiModelProperty(value = "应审批用户ID",example="")
	private String shouldUserId;
	/**
	 * 应审批用户
	 */
    @ApiModelProperty(value = "应审批用户",example="")
	private String shouldUserName;
	/**
	 * 实际处理用户ID
	 */
    @ApiModelProperty(value = "实际处理用户ID",example="")
	private String handleUserId;
	/**
	 * 实际处理用户
	 */
    @ApiModelProperty(value = "实际处理用户",example="")
	private String handleUserName;
	/**
	 * 处理时间
	 */
    @ApiModelProperty(value = "处理时间",example="")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date handleTime;
	/**
	 * 处理意见
	 */
    @ApiModelProperty(value = "处理意见",example="")
	private String handleOpinion;
	/**
	 * 处理类型（2审批通过；3审批不通过；4撤销）
	 */
    @ApiModelProperty(value = "处理类型（2审批通过；3审批不通过；4撤销）",example="")
	private String handleType;

}
