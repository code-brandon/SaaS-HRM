package com.xiaozheng.socialsecurity.service.ss;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.ss.SsArchiveDetailEntity;

import java.util.Map;

/**
 * 社保-归档详情
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-30 21:51:56
 */
public interface SsArchiveDetailService extends IService<SsArchiveDetailEntity> {

    PageUtils<SsArchiveDetailEntity> queryPage(SsArchiveDetailEntity ssArchiveDetail, Map<String, Object> params);

    /**
     * 分页条件查询所有翻译数据
     *
     * @param ssArchiveDetail,
     * @param params           请求集合
     * @return 所有数据
     */
    PageUtils<SsArchiveDetailEntity> queryPageAndTran(SsArchiveDetailEntity ssArchiveDetail, Map<String, Object> params);

    /**
     * 根据年月获取统计存档详细信息
     *
     * @param yearsMonth
     * @return
     */
    Map<String, Object> getCountArchiveDetail(String yearsMonth);
}

