package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteExtraDutyRuleEntity;

import java.util.Map;

/**
 * 加班规则
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteExtraDutyRuleService extends IService<AtteExtraDutyRuleEntity> {

    PageUtils<AtteExtraDutyRuleEntity> queryPage(AtteExtraDutyRuleEntity atteExtraDutyRule, Map<String, Object> params);
}

