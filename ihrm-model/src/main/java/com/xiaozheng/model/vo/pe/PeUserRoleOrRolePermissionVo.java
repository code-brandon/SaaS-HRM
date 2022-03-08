package com.xiaozheng.model.vo.pe;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.vo.pe
 * @ClassName: PeUserRoleVo
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/5 21:21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户分配角色或角色分配权限")
public class PeUserRoleOrRolePermissionVo implements Serializable {
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    private String userId;
    /**
     * 角色id集合
     */
    @ApiModelProperty("角色id集合")
    private List<String> roleIds;

    /**
     * 角色id
     */
    @ApiModelProperty("角色id集合")
    private String roleId;
    /**
     * 权限id集合
     */
    @ApiModelProperty("权限id集合")
    private Set<String> permIds;

}
