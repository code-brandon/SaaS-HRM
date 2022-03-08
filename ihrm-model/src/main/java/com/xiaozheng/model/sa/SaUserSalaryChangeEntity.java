package com.xiaozheng.model.sa;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("员工-员工薪酬变更")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_user_salary_change")
public class SaUserSalaryChangeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 调整前基本工资
     */
    @ApiModelProperty("调整前基本工资")
    private BigDecimal currentBasicSalary;
    /**
     * 调整前岗位工资
     */
    @ApiModelProperty("调整前岗位工资")
    private BigDecimal currentPostWage;
    /**
     * 调整基本工资
     */
    @ApiModelProperty("调整基本工资")
    private BigDecimal adjustmentOfBasicWages;
    /**
     * 调整岗位工资
     */
    @ApiModelProperty("调整岗位工资")
    private BigDecimal adjustPostWages;
    /**
     * 调薪生效时间
     */
    @ApiModelProperty("调薪生效时间")
    private Date effectiveTimeOfPayAdjustment;
    /**
     * 调薪原因
     */
    @ApiModelProperty("调薪原因")
    private String causeOfSalaryAdjustment;
    /**
     * 附件
     */
    @ApiModelProperty("附件")
    private String enclosure;

}
