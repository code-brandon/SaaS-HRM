package com.xiaozheng.salary.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.salary.dao.SaUserSalaryDao;
import com.xiaozheng.model.sa.SaUserSalaryEntity;
import com.xiaozheng.salary.service.SaUserSalaryService;

/**
 * 工资-员工薪资表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
@Service("saUserSalaryService")
public class SaUserSalaryServiceImpl extends ServiceImpl<SaUserSalaryDao, SaUserSalaryEntity> implements SaUserSalaryService {

    @Override
    public PageUtils<SaUserSalaryEntity> queryPage(SaUserSalaryEntity saUserSalary,Map<String, Object> params) {
        IPage<SaUserSalaryEntity> page = this.page(
                new Query<SaUserSalaryEntity>().getPage(params),
                Wrappers.query(saUserSalary)
        );
        return new PageUtils(page);
    }

}