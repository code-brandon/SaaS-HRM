package com.xiaozheng.model.co;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类代码：
 * 属性
 * 构造方法
 * getter，setter方法
 * <p>
 * lombok 插件 : 使用注解的形式替换getter setter，构造方法
 * 如何使用插件
 * 1.安装插件（在工程中引入响应的插件坐标即可）
 * <dependency>
 * <groupId>org.projectlombok</groupId>
 * <artifactId>lombok</artifactId>
 * <version>1.16.16</version>
 * </dependency>
 * 2.使用注解配置
 * 配置到实体类上
 *
 * @setter : setter方法
 * @getter ：getter方法
 * @NoArgsConstructor 无参构造
 * @AllArgsConstructor 满参构造
 * @Data : setter,getter,构造方法
 * <p>
 * 使用jpa操作数据
 * 配置实体类和数据库表的映射关系：jpa注解
 * 1.实体类和表的映射关系
 * 2.字段和属性的映射关系
 * i。主键属性的映射
 * ii。普通属性的映射
 */
@ApiModel("公司实体")
@TableName(value = "co_company")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoCompanyEntity implements Serializable {
    /**
     * ID
     */
    @ApiModelProperty("ID")
    @TableId(type = IdType.ASSIGN_ID)
    private String id;
    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String name;
    /**
     * 企业登录账号ID
     */
    @ApiModelProperty("企业登录账号ID")
    private String managerId;
    /**
     * 当前版本
     */
    @ApiModelProperty("当前版本")
    private String version;
    /**
     * 续期时间
     */
    @ApiModelProperty("续期时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date renewalDate;
    /**
     * 到期时间
     */
    @ApiModelProperty("到期时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date expirationDate;
    /**
     * 公司地区
     */
    @ApiModelProperty("公司地区")
    private String companyArea;
    /**
     * 公司地址
     */
    @ApiModelProperty("公司地址")
    private String companyAddress;
    /**
     * 营业执照-图片ID
     */
    @ApiModelProperty("营业执照-图片ID")
    private String businessLicenseId;
    /**
     * 法人代表
     */
    @ApiModelProperty("法人代表")
    private String legalRepresentative;
    /**
     * 公司电话
     */
    @ApiModelProperty("公司电话")
    private String companyPhone;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String mailbox;
    /**
     * 公司规模
     */
    @ApiModelProperty("公司规模")
    private String companySize;
    /**
     * 所属行业
     */
    @ApiModelProperty("所属行业")
    private String industry;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remarks;
    /**
     * 审核状态
     */
    @ApiModelProperty("审核状态")
    private String auditState;
    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer state;
    /**
     * 当前余额
     */
    @ApiModelProperty("当前余额")
    private Double balance;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date createTime;
}
