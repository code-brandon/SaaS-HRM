package com.xiaozheng.model.bs;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * bs_月份
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@ApiModel("bs_月份")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("bs_month")
public class BsMonthEntity extends Model<BsMonthEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
    @ApiModelProperty("")
	@TableId(type = IdType.ASSIGN_ID)
	private String month;

}
