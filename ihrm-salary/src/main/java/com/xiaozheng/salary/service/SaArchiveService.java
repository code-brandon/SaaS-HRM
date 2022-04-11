package com.xiaozheng.salary.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.sa.SaArchiveEntity;

import java.util.Map;

/**
 * 工资-归档表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-11 23:22:51
 */
public interface SaArchiveService extends IService<SaArchiveEntity> {

    PageUtils<SaArchiveEntity> queryPage(SaArchiveEntity saArchive, Map<String, Object> params);
}

