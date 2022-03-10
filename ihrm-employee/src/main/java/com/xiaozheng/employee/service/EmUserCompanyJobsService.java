package com.xiaozheng.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.employee.entity.EmUserCompanyJobsEntity;

import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
public interface EmUserCompanyJobsService extends IService<EmUserCompanyJobsEntity> {

    PageUtils<EmUserCompanyJobsEntity> queryPage(EmUserCompanyJobsEntity emUserCompanyJobs, Map<String, Object> params);
}

