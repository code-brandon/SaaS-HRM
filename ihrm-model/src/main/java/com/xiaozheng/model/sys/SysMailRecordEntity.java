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
 * 系统邮件记录表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
@ApiModel("系统邮件记录")
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("sys_mail_record")
public class SysMailRecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 邮件接收邮箱
     */
    @ApiModelProperty("邮件接收邮箱")
    private String recipient;
    /**
     * 邮件主题
     */
    @ApiModelProperty("邮件主题")
    private String subject;
    /**
     * 邮件内容
     */
    @ApiModelProperty("邮件内容")
    private String content;
    /**
     *
     */
    @ApiModelProperty("")
    private String createBy;
    /**
     *
     */
    @ApiModelProperty("")
    private Date createDate;
    /**
     *
     */
    @ApiModelProperty("")
    private String updateBy;
    /**
     *
     */
    @ApiModelProperty("")
    private Date updateDate;
    /**
     *
     */
    @ApiModelProperty("")
    private String remarks;

}
