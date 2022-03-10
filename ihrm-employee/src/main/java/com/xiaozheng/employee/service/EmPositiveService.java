package com.xiaozheng.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.em.EmPositiveEntity;

import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
public interface EmPositiveService extends IService<EmPositiveEntity> {

    PageUtils<EmPositiveEntity> queryPage(EmPositiveEntity emPositive, Map<String, Object> params);
}

