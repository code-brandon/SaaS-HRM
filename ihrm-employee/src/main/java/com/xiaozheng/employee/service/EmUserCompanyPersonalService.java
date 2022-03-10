package com.xiaozheng.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.employee.entity.EmUserCompanyPersonalEntity;

import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
public interface EmUserCompanyPersonalService extends IService<EmUserCompanyPersonalEntity> {

    PageUtils<EmUserCompanyPersonalEntity> queryPage(EmUserCompanyPersonalEntity emUserCompanyPersonal, Map<String, Object> params);
}

