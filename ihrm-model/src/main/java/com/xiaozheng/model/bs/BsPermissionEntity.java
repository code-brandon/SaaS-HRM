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
 * bs_许可
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@ApiModel("bs_许可")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("bs_permission")
public class BsPermissionEntity extends Model<BsPermissionEntity> implements Serializable {
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
	private String userId;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String companyId;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String administratorName;
	/**
	 * 
	 */
    @ApiModelProperty("")
	private String managementModule;

}
