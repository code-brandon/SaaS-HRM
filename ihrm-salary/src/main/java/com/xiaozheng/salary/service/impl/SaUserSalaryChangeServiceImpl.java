package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaUserSalaryChangeDao;
import com.xiaozheng.model.sa.SaUserSalaryChangeEntity;
import com.xiaozheng.salary.service.SaUserSalaryChangeService;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Service("saUserSalaryChangeService")
public class SaUserSalaryChangeServiceImpl extends ServiceImpl<SaUserSalaryChangeDao, SaUserSalaryChangeEntity> implements SaUserSalaryChangeService {

    @Override
    public PageUtils<SaUserSalaryChangeEntity> queryPage(SaUserSalaryChangeEntity saUserSalaryChange,Map<String, Object> params) {
        IPage<SaUserSalaryChangeEntity> page = this.page(
                new Query<SaUserSalaryChangeEntity>().getPage(params),
                Wrappers.query(saUserSalaryChange)
        );
        return new PageUtils(page);
    }

}