package com.xiaozheng.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.xiaozheng.model.pe.PeRoleEntity;
import com.xiaozheng.model.pe.PeUserEntity;
import com.xiaozheng.model.vo.pe.PeUsetVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.dto
 * @ClassName: PeUserDto
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/2/13 17:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeUserDto extends PeUsetVo {

    /**
     * 角色
     */
    @JsonInclude(value= JsonInclude.Include.NON_NULL)
    private Map<String, Object> roles;
}
