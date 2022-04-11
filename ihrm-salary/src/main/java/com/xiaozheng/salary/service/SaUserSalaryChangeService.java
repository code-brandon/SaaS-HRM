package com.xiaozheng.salary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.sa.SaUserSalaryChangeEntity;

import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:52
 */
public interface SaUserSalaryChangeService extends IService<SaUserSalaryChangeEntity> {

    PageUtils<SaUserSalaryChangeEntity> queryPage(SaUserSalaryChangeEntity saUserSalaryChange, Map<String, Object> params);
}

