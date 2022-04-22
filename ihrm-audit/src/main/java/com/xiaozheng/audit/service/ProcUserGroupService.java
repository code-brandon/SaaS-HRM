package com.xiaozheng.audit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.proc.ProcUserGroupEntity;

import java.util.Map;

/**
 * 流程 拓展表 -- 业务流程的用户组表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
public interface ProcUserGroupService extends IService<ProcUserGroupEntity> {

    PageUtils<ProcUserGroupEntity> queryPage(ProcUserGroupEntity procUserGroup, Map<String, Object> params);
}

