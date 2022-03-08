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
 * 工资-归档表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:36
 */
@ApiModel("工资-归档表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sa_archive")
public class SaArchiveEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 企业id
     */
    @ApiModelProperty("企业id")
    private String companyId;
    /**
     * 年月
     */
    @ApiModelProperty("年月")
    private String yearsMonth;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date creationTime;
    /**
     * 人工成本
     */
    @ApiModelProperty("人工成本")
    private BigDecimal artificialCost;
    /**
     * 税前工资
     */
    @ApiModelProperty("税前工资")
    private BigDecimal grossSalary;
    /**
     * 五险一金
     */
    @ApiModelProperty("五险一金")
    private BigDecimal fiveInsurances;

}
