package com.xiaozheng.model.bs;

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
 * bs_城市
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@ApiModel("bs_城市")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("bs_city")
public class BsCityEntity extends Model<BsCityEntity> implements Serializable {
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
	private String name;
	/**
	 * 
	 */
    @ApiModelProperty("")
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date createTime;

}
