package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteAttendanceConfigEntity;

import java.util.Map;

/**
 * 考勤配置表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteAttendanceConfigService extends IService<AtteAttendanceConfigEntity> {

    PageUtils<AtteAttendanceConfigEntity> queryPage(AtteAttendanceConfigEntity atteAttendanceConfig, Map<String, Object> params);

    /**
     * 通过部门ID和企业ID查询考勤配置
     * @param departmentId 部门ID
     * @return
     */
    AtteAttendanceConfigEntity getByDeptIdAndcompanyId(String departmentId);

    /**
     * 保存或修改企业考勤设置
     *
     * @param atteAttendanceConfig 实体对象
     * @return 修改结果
     */
    boolean updateOrSave(AtteAttendanceConfigEntity atteAttendanceConfig);

}

