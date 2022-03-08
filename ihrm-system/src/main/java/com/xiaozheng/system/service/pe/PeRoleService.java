package com.xiaozheng.system.service.pe;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.PeRoleDto;
import com.xiaozheng.model.pe.PeRoleEntity;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
public interface PeRoleService extends IService<PeRoleEntity> {

    PageUtils<PeRoleEntity> queryPage(PeRoleEntity peRole, Map<String, Object> params);

    /**
     * 通过主键查询单条数据和所关联权限
     *
     * @param id 主键
     * @return 单条数据
     */
    PeRoleDto infoAndPermById(String id);
}

