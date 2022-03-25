package com.xiaozheng.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.xiaozheng.model.annotation.ExcelAttribute;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
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
 * @ClassName: UserDetailAndResignationDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/19 23:02
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailAndResignationDto extends EmUserCompanyPersonalEntity implements Serializable {

    /**
     * 离职时间
     */
    @ApiModelProperty("离职时间")
    @ExcelAttribute(sort = 12)
    private String resignationTime;
    /**
     * 离职类型
     */
    @ApiModelProperty("离职类型")
    @ExcelAttribute(sort = 10)
    private String typeOfTurnover;
    /**
     * 申请离职原因
     */
    @ApiModelProperty("申请离职原因")
    @ExcelAttribute(sort = 11)
    private String reasonsForLeaving;

}
