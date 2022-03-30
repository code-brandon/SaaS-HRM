package com.xiaozheng.socialsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsArchiveEntity;

import java.util.Map;

/**
 * 社保-归档表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsArchiveService extends IService<SsArchiveEntity> {

    PageUtils<SsArchiveEntity> queryPage(SsArchiveEntity ssArchive, Map<String, Object> params);
}

