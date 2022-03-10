package com.xiaozheng.model.em;

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
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@ApiModel("")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_transferposition")
public class EmTransferpositionEntity extends Model<EmTransferpositionEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
    @ApiModelProperty("用户ID")
	@TableId(type = IdType.ASSIGN_ID)
	private String userId;
	/**
	 * 岗位
	 */
    @ApiModelProperty("岗位")
	private String post;
	/**
	 * 职级
	 */
    @ApiModelProperty("职级")
	private String rank;
	/**
	 * 汇报对象
	 */
    @ApiModelProperty("汇报对象")
	private String reportingObject;
	/**
	 * HRBP
	 */
    @ApiModelProperty("HRBP")
	private String hrbp;
	/**
	 * 调岗时间
	 */
    @ApiModelProperty("调岗时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date adjustmentTime;
	/**
	 * 调岗原因
	 */
    @ApiModelProperty("调岗原因")
	private String causeOfAdjustingPost;
	/**
	 * 附件 [1,2,3]
	 */
    @ApiModelProperty("附件 [1,2,3]")
	private String enclosure;
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
	 * 纳税城市
	 */
    @ApiModelProperty("纳税城市")
	private String taxableCity;
	/**
	 * 现合同开始时间
	 */
    @ApiModelProperty("现合同开始时间")
	private String currentContractStartTime;
	/**
	 * 现合同结束时间
	 */
    @ApiModelProperty("现合同结束时间")
	private String closingTimeOfCurrentContract;
	/**
	 * 工作地点
	 */
    @ApiModelProperty("工作地点")
	private String workingPlace;
	/**
	 * 首次合同开始时间
	 */
    @ApiModelProperty("首次合同开始时间")
	private String initialContractStartTime;
	/**
	 * 首次合同结束时间
	 */
    @ApiModelProperty("首次合同结束时间")
	private String firstContractTerminationTime;
	/**
	 * 合同期限
	 */
    @ApiModelProperty("合同期限")
	private String contractPeriod;
	/**
	 * 续签次数
	 */
    @ApiModelProperty("续签次数")
	private Integer renewalNumber;
	/**
	 * 推荐企业人
	 */
    @ApiModelProperty("推荐企业人")
	private String recommenderBusinessPeople;
	/**
	 * 单据状态 1是未执行，2是已执行
	 */
    @ApiModelProperty("单据状态 1是未执行，2是已执行")
	private Integer estatus;
	/**
	 * 创建时间
	 */
    @ApiModelProperty("创建时间")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

}
