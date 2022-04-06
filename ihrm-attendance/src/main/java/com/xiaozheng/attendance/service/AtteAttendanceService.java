package com.xiaozheng.attendance.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.atte.AtteAttendanceEntity;
import com.xiaozheng.model.bo.AtteAttendanceBo;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 考勤表
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
public interface AtteAttendanceService extends IService<AtteAttendanceEntity> {

    PageUtils<AtteAttendanceEntity> queryPage(AtteAttendanceEntity atteAttendance, Map<String, Object> params);

    /**
     * 考勤数据Excel上传
     * @param file
     * @return 是否成功
     */
    boolean importExcel(MultipartFile file) throws Exception;

    /**
     * 分页条件查询用户考勤
     * @param atteAttendance
     * @param params
     * @return
     */
    PageUtils<AtteAttendanceBo> queryAtte(AtteAttendanceEntity atteAttendance, Map<String, Object> params);

    /**
     * 修改考勤数据
     * @param atteAttendance
     * @return
     */
    boolean updateOrSave(AtteAttendanceEntity atteAttendance) throws CommonException;
}

