package com.xiaozheng.audit.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.audit.dao.ProcTaskInstanceDao;
import com.xiaozheng.audit.service.ProcTaskInstanceService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.proc.ProcTaskInstanceEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 流程 拓展表 -- 业务流程的任务表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-17 12:17:36
 */
@Service("procTaskInstanceService")
public class ProcTaskInstanceServiceImpl extends ServiceImpl<ProcTaskInstanceDao, ProcTaskInstanceEntity> implements ProcTaskInstanceService {

    @Override
    public PageUtils<ProcTaskInstanceEntity> queryPage(ProcTaskInstanceEntity procTaskInstance, Map<String, Object> params) {
        IPage<ProcTaskInstanceEntity> page = this.page(
                new Query<ProcTaskInstanceEntity>().getPage(params),
                Wrappers.query(procTaskInstance)
        );
        return new PageUtils(page);
    }

}