package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteLeaveConfigDao;
import com.xiaozheng.attendance.service.AtteLeaveConfigService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteLeaveConfigEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 请假配置表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteLeaveConfigService")
public class AtteLeaveConfigServiceImpl extends ServiceImpl<AtteLeaveConfigDao, AtteLeaveConfigEntity> implements AtteLeaveConfigService {

    @Override
    public PageUtils<AtteLeaveConfigEntity> queryPage(AtteLeaveConfigEntity atteLeaveConfig,Map<String, Object> params) {
        IPage<AtteLeaveConfigEntity> page = this.page(
                new Query<AtteLeaveConfigEntity>().getPage(params),
                Wrappers.query(atteLeaveConfig)
        );
        return new PageUtils(page);
    }

}