package com.xiaozheng.audit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.audit.dao.ProcUserGroupDao;
import com.xiaozheng.audit.service.ProcUserGroupService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.proc.ProcUserGroupEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 流程 拓展表 -- 业务流程的用户组表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Service("procUserGroupService")
public class ProcUserGroupServiceImpl extends ServiceImpl<ProcUserGroupDao, ProcUserGroupEntity> implements ProcUserGroupService {

    @Override
    public PageUtils<ProcUserGroupEntity> queryPage(ProcUserGroupEntity procUserGroup,Map<String, Object> params) {
        IPage<ProcUserGroupEntity> page = this.page(
                new Query<ProcUserGroupEntity>().getPage(params),
                Wrappers.query(procUserGroup)
        );
        return new PageUtils(page);
    }

}