package com.xiaozheng.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.xiaozheng.model.pe.PeRoleEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.dto
 * @ClassName: PeRoleDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/2/13 17:52
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeRoleDto extends PeRoleEntity implements Serializable {

    /**
     * 权限 ID
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    @ApiModelProperty("权限 ID")
    private String permIds;



}
