package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteArchiveMonthlyEntity;

import java.util.Map;

/**
 * 考勤归档信息表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteArchiveMonthlyService extends IService<AtteArchiveMonthlyEntity> {

    PageUtils<AtteArchiveMonthlyEntity> queryPage(AtteArchiveMonthlyEntity atteArchiveMonthly, Map<String, Object> params);
}

