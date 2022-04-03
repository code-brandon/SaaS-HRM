package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteAttendanceDao;
import com.xiaozheng.attendance.service.AtteAttendanceService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteAttendanceEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteAttendanceService")
public class AtteAttendanceServiceImpl extends ServiceImpl<AtteAttendanceDao, AtteAttendanceEntity> implements AtteAttendanceService {

    @Override
    public PageUtils<AtteAttendanceEntity> queryPage(AtteAttendanceEntity atteAttendance,Map<String, Object> params) {
        IPage<AtteAttendanceEntity> page = this.page(
                new Query<AtteAttendanceEntity>().getPage(params),
                Wrappers.query(atteAttendance)
        );
        return new PageUtils(page);
    }

}