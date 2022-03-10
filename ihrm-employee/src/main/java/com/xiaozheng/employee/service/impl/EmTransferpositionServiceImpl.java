package com.xiaozheng.employee.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.employee.dao.EmTransferpositionDao;
import com.xiaozheng.model.em.EmTransferpositionEntity;
import com.xiaozheng.employee.service.EmTransferpositionService;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emTransferpositionService")
public class EmTransferpositionServiceImpl extends ServiceImpl<EmTransferpositionDao, EmTransferpositionEntity> implements EmTransferpositionService {

    @Override
    public PageUtils<EmTransferpositionEntity> queryPage(EmTransferpositionEntity emTransferposition,Map<String, Object> params) {
        IPage<EmTransferpositionEntity> page = this.page(
                new Query<EmTransferpositionEntity>().getPage(params),
                Wrappers.query(emTransferposition)
        );
        return new PageUtils(page);
    }

}