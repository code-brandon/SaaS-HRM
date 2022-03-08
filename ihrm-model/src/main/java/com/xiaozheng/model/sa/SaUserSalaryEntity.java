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

/**
 * 工资-员工薪资表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("工资-员工薪资表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_user_salary")
public class SaUserSalaryEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("")
    @TableId(type = IdType.ASSIGN_ID)
    private String userId;
    /**
     * 当前基本工资
     */
    @ApiModelProperty("当前基本工资")
    private BigDecimal currentBasicSalary;
    /**
     * 当前岗位工资
     */
    @ApiModelProperty("当前岗位工资")
    private BigDecimal currentPostWage;
    /**
     * 定薪基本工资
     */
    @ApiModelProperty("定薪基本工资")
    private BigDecimal fixedBasicSalary;
    /**
     * 定薪岗位工资
     */
    @ApiModelProperty("定薪岗位工资")
    private BigDecimal fixedPostWage;
    /**
     * 转正基本工资
     */
    @ApiModelProperty("转正基本工资")
    private BigDecimal correctionOfBasicWages;
    /**
     * 转正岗位工资
     */
    @ApiModelProperty("转正岗位工资")
    private BigDecimal turnToPostWages;

}
