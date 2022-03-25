package com.xiaozheng.model.em;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.xiaozheng.model.annotation.ExcelAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * 
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@ApiModel("员工详细信息表")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@TableName("em_user_company_personal")
public class EmUserCompanyPersonalEntity extends Model<EmUserCompanyPersonalEntity> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 用户ID
	 */
    @ApiModelProperty("用户ID")
	@TableId(type = IdType.INPUT)
	@ExcelAttribute(sort = 0)
	private String userId;
	/**
	 * 
	 */
    @ApiModelProperty("用户名")
	@ExcelAttribute(sort = 1)
	private String username;
	/**
	 * 
	 */
    @ApiModelProperty("手机号")
	@ExcelAttribute(sort = 2)
	private String mobile;
	/**
	 * 
	 */
    @ApiModelProperty("入职时间")
	@ExcelAttribute(sort = 9)
	private String timeOfEntry;
	/**
	 * 
	 */
    @ApiModelProperty("部门名称")
	private String departmentName;
	/**
	 * 公司ID
	 */
    @ApiModelProperty("公司ID")
	private String companyId;
	/**
	 * 性别
	 */
    @ApiModelProperty("性别")
	private String sex;
	/**
	 * 出生日期
	 */
    @ApiModelProperty("出生日期")
	private String dateOfBirth;
	/**
	 * 最高学历
	 */
    @ApiModelProperty("最高学历")
	@ExcelAttribute(sort = 3)
	private String theHighestDegreeOfEducation;
	/**
	 * 国家地区
	 */
    @ApiModelProperty("国家地区")
	@ExcelAttribute(sort = 4)
	private String nationalArea;
	/**
	 * 护照号
	 */
    @ApiModelProperty("护照号")
	@ExcelAttribute(sort = 5)
	private String passportNo;
	/**
	 * 身份证号
	 */
    @ApiModelProperty("身份证号")
	private String idNumber;
	/**
	 * 身份证照片-正面
	 */
    @ApiModelProperty("身份证照片-正面")
	private String idCardPhotoPositive;
	/**
	 * 身份证照片-背面
	 */
    @ApiModelProperty("身份证照片-背面")
	private String idCardPhotoBack;
	/**
	 * 籍贯
	 */
    @ApiModelProperty("籍贯")
	@ExcelAttribute(sort = 6)
	private String nativePlace;
	/**
	 * 民族
	 */
    @ApiModelProperty("民族")
	private String nation;
	/**
	 * 英文名
	 */
    @ApiModelProperty("英文名")
	private String englishName;
	/**
	 * 婚姻状况
	 */
    @ApiModelProperty("婚姻状况")
	private String maritalStatus;
	/**
	 * 员工照片
	 */
    @ApiModelProperty("员工照片")
	private String staffPhoto;
	/**
	 * 生日
	 */
    @ApiModelProperty("生日")
	@ExcelAttribute(sort = 7)
	private String birthday;
	/**
	 * 属相
	 */
    @ApiModelProperty("属相")
	@ExcelAttribute(sort = 8)
	private String zodiac;
	/**
	 * 年龄
	 */
    @ApiModelProperty("年龄")
	private String age;
	/**
	 * 星座
	 */
    @ApiModelProperty("星座")
	private String constellation;
	/**
	 * 血型
	 */
    @ApiModelProperty("血型")
	private String bloodType;
	/**
	 * 户籍所在地
	 */
    @ApiModelProperty("户籍所在地")
	private String domicile;
	/**
	 * 政治面貌
	 */
    @ApiModelProperty("政治面貌")
	private String politicalOutlook;
	/**
	 * 入党时间
	 */
    @ApiModelProperty("入党时间")
	private String timeToJoinTheParty;
	/**
	 * 存档机构
	 */
    @ApiModelProperty("存档机构")
	private String archivingOrganization;
	/**
	 * 子女状态
	 */
    @ApiModelProperty("子女状态")
	private String stateOfChildren;
	/**
	 * 子女有无商业保险
	 */
    @ApiModelProperty("子女有无商业保险")
	private String doChildrenHaveCommercialInsurance;
	/**
	 * 有无违法违纪行为
	 */
    @ApiModelProperty("有无违法违纪行为")
	private String isThereAnyViolationOfLawOrDiscipline;
	/**
	 * 有无重大病史
	 */
    @ApiModelProperty("有无重大病史")
	private String areThereAnyMajorMedicalHistories;
	/**
	 * QQ
	 */
    @ApiModelProperty("QQ")
	private String qq;
	/**
	 * 微信
	 */
    @ApiModelProperty("微信")
	private String wechat;
	/**
	 * 居住证城市
	 */
    @ApiModelProperty("居住证城市")
	private String residenceCardCity;
	/**
	 * 居住证办理日期
	 */
    @ApiModelProperty("居住证办理日期")
	private String dateOfResidencePermit;
	/**
	 * 居住证截止日期
	 */
    @ApiModelProperty("居住证截止日期")
	private String residencePermitDeadline;
	/**
	 * 现居住地
	 */
    @ApiModelProperty("现居住地")
	private String placeOfResidence;
	/**
	 * 通讯地址
	 */
    @ApiModelProperty("通讯地址")
	private String postalAddress;
	/**
	 * 
	 */
    @ApiModelProperty("联系手机")
	private String contactTheMobilePhone;
	/**
	 * 
	 */
    @ApiModelProperty("个人邮箱")
	private String personalMailbox;
	/**
	 * 紧急联系人
	 */
    @ApiModelProperty("紧急联系人")
	private String emergencyContact;
	/**
	 * 紧急联系电话
	 */
    @ApiModelProperty("紧急联系电话")
	private String emergencyContactNumber;
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
	/**
	 * 银行卡号
	 */
    @ApiModelProperty("银行卡号")
	private String bankCardNumber;
	/**
	 * 开户行
	 */
    @ApiModelProperty("开户行")
	private String openingBank;
	/**
	 * 学历类型
	 */
    @ApiModelProperty("学历类型")
	private String educationalType;
	/**
	 * 毕业学校
	 */
    @ApiModelProperty("毕业学校")
	private String graduateSchool;
	/**
	 * 入学时间
	 */
    @ApiModelProperty("入学时间")
	private String enrolmentTime;
	/**
	 * 毕业时间
	 */
    @ApiModelProperty("毕业时间")
	private String graduationTime;
	/**
	 * 专业
	 */
    @ApiModelProperty("专业")
	private String major;
	/**
	 * 毕业证书
	 */
    @ApiModelProperty("毕业证书")
	private String graduationCertificate;
	/**
	 * 学位证书
	 */
    @ApiModelProperty("学位证书")
	private String certificateOfAcademicDegree;
	/**
	 * 上家公司
	 */
    @ApiModelProperty("上家公司")
	private String homeCompany;
	/**
	 * 职称
	 */
    @ApiModelProperty("职称")
	private String title;
	/**
	 * 简历
	 */
    @ApiModelProperty("简历")
	private String resume;
	/**
	 * 有无竞业限制
	 */
    @ApiModelProperty("有无竞业限制")
	private String isThereAnyCompetitionRestriction;
	/**
	 * 前公司离职证明
	 */
    @ApiModelProperty("前公司离职证明")
	private String proofOfDepartureOfFormerCompany;
	/**
	 * 备注
	 */
    @ApiModelProperty("备注")
	private String remarks;

}
