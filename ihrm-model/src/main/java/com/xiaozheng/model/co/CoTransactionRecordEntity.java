package com.xiaozheng.model.co;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@ApiModel("共同交易记录")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("co_transaction_record")
public class CoTransactionRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @ApiModelProperty("")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     *
     */
    @ApiModelProperty("")
    private String companyId;
    /**
     *
     */
    @ApiModelProperty("")
    private String userId;
    /**
     *
     */
    @ApiModelProperty("")
    private Integer type;
    /**
     *
     */
    @ApiModelProperty("")
    private Double amount;
    /**
     *
     */
    @ApiModelProperty("")
    private Double balance;
    /**
     *
     */
    @ApiModelProperty("")
    private String note;
    /**
     *
     */
    @ApiModelProperty("")
    private Date createTime;

}
