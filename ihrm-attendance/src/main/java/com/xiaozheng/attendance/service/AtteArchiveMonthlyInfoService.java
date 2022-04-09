package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteArchiveMonthlyInfoEntity;

import java.util.Map;

/**
 * 考勤归档信息详情表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteArchiveMonthlyInfoService extends IService<AtteArchiveMonthlyInfoEntity> {

    PageUtils<AtteArchiveMonthlyInfoEntity> queryPage(AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo, Map<String, Object> params);

    PageUtils<AtteArchiveMonthlyInfoEntity> queryPageAndDate(AtteArchiveMonthlyInfoEntity atteArchiveMonthlyInfo, Map<String, Object> params);

}

