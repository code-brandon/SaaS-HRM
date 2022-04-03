package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteAttendanceConfigDao;
import com.xiaozheng.attendance.service.AtteAttendanceConfigService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteAttendanceConfigEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤配置表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteAttendanceConfigService")
public class AtteAttendanceConfigServiceImpl extends ServiceImpl<AtteAttendanceConfigDao, AtteAttendanceConfigEntity> implements AtteAttendanceConfigService {

    @Override
    public PageUtils<AtteAttendanceConfigEntity> queryPage(AtteAttendanceConfigEntity atteAttendanceConfig,Map<String, Object> params) {
        IPage<AtteAttendanceConfigEntity> page = this.page(
                new Query<AtteAttendanceConfigEntity>().getPage(params),
                Wrappers.query(atteAttendanceConfig)
        );
        return new PageUtils(page);
    }

}