package com.xiaozheng.company.service.co;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.co.CoTransactionRecordEntity;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
public interface CoTransactionRecordService extends IService<CoTransactionRecordEntity> {

    PageUtils<CoTransactionRecordEntity> page(Map<String, Object> params);

    PageUtils<CoTransactionRecordEntity> queryPage(CoTransactionRecordEntity coTransactionRecord, Map<String, Object> params);
}

