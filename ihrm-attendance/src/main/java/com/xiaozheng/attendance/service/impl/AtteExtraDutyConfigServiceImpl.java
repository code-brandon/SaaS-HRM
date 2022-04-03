package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteExtraDutyConfigDao;
import com.xiaozheng.attendance.service.AtteExtraDutyConfigService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteExtraDutyConfigEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 加班配置表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteExtraDutyConfigService")
public class AtteExtraDutyConfigServiceImpl extends ServiceImpl<AtteExtraDutyConfigDao, AtteExtraDutyConfigEntity> implements AtteExtraDutyConfigService {

    @Override
    public PageUtils<AtteExtraDutyConfigEntity> queryPage(AtteExtraDutyConfigEntity atteExtraDutyConfig,Map<String, Object> params) {
        IPage<AtteExtraDutyConfigEntity> page = this.page(
                new Query<AtteExtraDutyConfigEntity>().getPage(params),
                Wrappers.query(atteExtraDutyConfig)
        );
        return new PageUtils(page);
    }

}