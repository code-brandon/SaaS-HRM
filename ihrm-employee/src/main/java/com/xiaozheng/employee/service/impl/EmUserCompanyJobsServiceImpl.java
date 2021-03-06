package com.xiaozheng.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.employee.dao.EmUserCompanyJobsDao;
import com.xiaozheng.employee.service.EmUserCompanyJobsService;
import com.xiaozheng.common.entity.PeUserDto;
import com.xiaozheng.model.em.EmUserCompanyJobsEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emUserCompanyJobsService")
public class EmUserCompanyJobsServiceImpl extends ServiceImpl<EmUserCompanyJobsDao, EmUserCompanyJobsEntity> implements EmUserCompanyJobsService {

    @Override
    public PageUtils<EmUserCompanyJobsEntity> queryPage(EmUserCompanyJobsEntity emUserCompanyJobs,Map<String, Object> params) {
        IPage<EmUserCompanyJobsEntity> page = this.page(
                new Query<EmUserCompanyJobsEntity>().getPage(params),
                Wrappers.query(emUserCompanyJobs)
        );
        return new PageUtils(page);
    }

    /**
     * 保存或更新数据
     *
     * @param emUserCompanyJobs
     * @return
     */
    @Override
    public boolean updateOrSave(EmUserCompanyJobsEntity emUserCompanyJobs) {
        PeUserDto profile = ShiroContextUtils.getProfile();
        emUserCompanyJobs.setCompanyId(profile.getCompanyId());
        return this.saveOrUpdate(emUserCompanyJobs, new UpdateWrapper<EmUserCompanyJobsEntity>().eq("user_id", emUserCompanyJobs.getUserId()));
    }

}