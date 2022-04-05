package com.xiaozheng.model.bo;

import com.xiaozheng.model.atte.AtteAttendanceEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.dto
 * @ClassName: AtteAttendanceDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/5 13:41
 */
@ApiModel("用户的出勤列表")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtteAttendanceBo implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String username;
    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String mobile;
    /**
     * 工号
     */
    @ApiModelProperty("工号")
    private String workNumber;
    /**
     * 部门
     */
    @ApiModelProperty("部门")
    private String departmentName;

    /**
     * 出勤列表
     */
    @ApiModelProperty("出勤列表")
    private  List<AtteAttendanceEntity> attendances;
}
