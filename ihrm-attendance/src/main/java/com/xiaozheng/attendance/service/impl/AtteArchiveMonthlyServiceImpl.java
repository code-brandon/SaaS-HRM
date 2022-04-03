package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteArchiveMonthlyDao;
import com.xiaozheng.attendance.service.AtteArchiveMonthlyService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteArchiveMonthlyEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤归档信息表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteArchiveMonthlyService")
public class AtteArchiveMonthlyServiceImpl extends ServiceImpl<AtteArchiveMonthlyDao, AtteArchiveMonthlyEntity> implements AtteArchiveMonthlyService {

    @Override
    public PageUtils<AtteArchiveMonthlyEntity> queryPage(AtteArchiveMonthlyEntity atteArchiveMonthly,Map<String, Object> params) {
        IPage<AtteArchiveMonthlyEntity> page = this.page(
                new Query<AtteArchiveMonthlyEntity>().getPage(params),
                Wrappers.query(atteArchiveMonthly)
        );
        return new PageUtils(page);
    }

}