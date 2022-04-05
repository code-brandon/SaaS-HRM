package com.xiaozheng.model.vo.atte;

import com.xiaozheng.model.annotation.ExcelAttribute;
import lombok.*;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AtteUploadVo {

	//员工姓名	手机号	工号	上班时间	下班时间
	@ExcelAttribute(sort=0,format="String")
	private String username;
	@ExcelAttribute(sort=1,format="String")
	private String mobile;
	@ExcelAttribute(sort=2,format="String")
	private String workNumber;
	@ExcelAttribute(sort=3,format="Date")
	private Date inTime;
	@ExcelAttribute(sort=4,format="Date")
	private Date outTime;
	@ExcelAttribute(sort=5,format="String")
	private String atteDate;
}
