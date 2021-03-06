package com.xiaozheng.model.dto;

import com.xiaozheng.model.ss.SsUserSocialSecurityEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.dto
 * @ClassName: SsUserSocialSecurityDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/31 14:23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SsUserSocialSecurityDto extends SsUserSocialSecurityEntity implements Serializable {
    /**
     * 手机号码
     */
    @ApiModelProperty("手机号码")
    private String mobile;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String username;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private String workNumber;
    /**
     * 部门名称
     */
    @ApiModelProperty("部门名称")
    private String departmentName;

    /**
     * 入职时间
     */
    @ApiModelProperty("入职时间")
    private String timeOfEntry;



    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private String theHighestDegreeOfEducation;
    /**
     * 开户行
     */
    @ApiModelProperty("开户行")
    private String openingBank;
    /**
     * 银行卡号
     */
    @ApiModelProperty("银行卡号")
    private String bankCardNumber;
    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String idNumber;
    /**
	 * 社保电脑号
	 */
    @ApiModelProperty("社保电脑号")
    private String socialSecurityComputerNumber;
    /**
     * 公积金账号
     */
    @ApiModelProperty("公积金账号")
    private String providentFundAccount;
}
