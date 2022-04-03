package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteExtraDutyRuleDao;
import com.xiaozheng.attendance.service.AtteExtraDutyRuleService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteExtraDutyRuleEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 加班规则实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteExtraDutyRuleService")
public class AtteExtraDutyRuleServiceImpl extends ServiceImpl<AtteExtraDutyRuleDao, AtteExtraDutyRuleEntity> implements AtteExtraDutyRuleService {

    @Override
    public PageUtils<AtteExtraDutyRuleEntity> queryPage(AtteExtraDutyRuleEntity atteExtraDutyRule,Map<String, Object> params) {
        IPage<AtteExtraDutyRuleEntity> page = this.page(
                new Query<AtteExtraDutyRuleEntity>().getPage(params),
                Wrappers.query(atteExtraDutyRule)
        );
        return new PageUtils(page);
    }

}