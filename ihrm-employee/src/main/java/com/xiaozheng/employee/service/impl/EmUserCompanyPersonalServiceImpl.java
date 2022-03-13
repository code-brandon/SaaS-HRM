package com.xiaozheng.employee.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.employee.dao.EmUserCompanyPersonalDao;
import com.xiaozheng.employee.service.EmUserCompanyPersonalService;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emUserCompanyPersonalService")
public class EmUserCompanyPersonalServiceImpl extends ServiceImpl<EmUserCompanyPersonalDao, EmUserCompanyPersonalEntity> implements EmUserCompanyPersonalService {

    @Override
    public PageUtils<EmUserCompanyPersonalEntity> queryPage(EmUserCompanyPersonalEntity emUserCompanyPersonal,Map<String, Object> params) {
        IPage<EmUserCompanyPersonalEntity> page = this.page(
                new Query<EmUserCompanyPersonalEntity>().getPage(params),
                Wrappers.query(emUserCompanyPersonal)
        );
        return new PageUtils(page);
    }

}