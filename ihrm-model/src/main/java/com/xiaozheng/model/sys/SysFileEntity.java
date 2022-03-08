package com.xiaozheng.model.sys;

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
@ApiModel("系统文件")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_file")
public class SysFileEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @ApiModelProperty("id")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 文件原始名称
     */
    @ApiModelProperty("文件原始名称")
    private String fileName;
    /**
     * 存储路径
     */
    @ApiModelProperty("存储路径")
    private String path;
    /**
     * 文件实际名称
     */
    @ApiModelProperty("文件实际名称")
    private String uuidName;
    /**
     * 文件类型
     */
    @ApiModelProperty("文件类型")
    private Integer type;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;

}
