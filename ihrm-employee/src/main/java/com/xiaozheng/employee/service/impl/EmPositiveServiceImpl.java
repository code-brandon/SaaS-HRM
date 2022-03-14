package com.xiaozheng.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.employee.dao.EmPositiveDao;
import com.xiaozheng.employee.service.EmPositiveService;
import com.xiaozheng.model.dto.PeUserDto;
import com.xiaozheng.model.em.EmPositiveEntity;
import com.xiaozheng.model.em.EmUserCompanyJobsEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emPositiveService")
public class EmPositiveServiceImpl extends ServiceImpl<EmPositiveDao, EmPositiveEntity> implements EmPositiveService {

    @Override
    public PageUtils<EmPositiveEntity> queryPage(EmPositiveEntity emPositive,Map<String, Object> params) {
        IPage<EmPositiveEntity> page = this.page(
                new Query<EmPositiveEntity>().getPage(params),
                Wrappers.query(emPositive)
        );
        return new PageUtils(page);
    }

    /**
     * 保存或更新数据
     *
     * @param emPositive
     * @return
     */
    @Override
    public boolean updateOrSave(EmPositiveEntity emPositive) {
        emPositive.setEstatus(1);
        return this.saveOrUpdate(emPositive, new UpdateWrapper<EmPositiveEntity>().eq("user_id", emPositive.getUserId()));
    }

}