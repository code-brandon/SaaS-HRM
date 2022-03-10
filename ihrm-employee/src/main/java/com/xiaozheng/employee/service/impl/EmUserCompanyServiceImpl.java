package com.xiaozheng.employee.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;

import com.xiaozheng.employee.dao.EmUserCompanyDao;
import com.xiaozheng.employee.entity.EmUserCompanyEntity;
import com.xiaozheng.employee.service.EmUserCompanyService;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emUserCompanyService")
public class EmUserCompanyServiceImpl extends ServiceImpl<EmUserCompanyDao, EmUserCompanyEntity> implements EmUserCompanyService {

    @Override
    public PageUtils<EmUserCompanyEntity> queryPage(EmUserCompanyEntity emUserCompany,Map<String, Object> params) {
        IPage<EmUserCompanyEntity> page = this.page(
                new Query<EmUserCompanyEntity>().getPage(params),
                Wrappers.query(emUserCompany)
        );
        return new PageUtils(page);
    }

}