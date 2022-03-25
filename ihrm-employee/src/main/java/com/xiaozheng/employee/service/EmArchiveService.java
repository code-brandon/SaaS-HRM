package com.xiaozheng.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.dto.UserDetailAndResignationDto;
import com.xiaozheng.model.em.EmArchiveEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
public interface EmArchiveService extends IService<EmArchiveEntity> {

    PageUtils<EmArchiveEntity> queryPage(EmArchiveEntity emArchive, Map<String, Object> params);

    List<EmArchiveEntity> archives(String month, Integer type);

    /**
     * 导出当月人事报表
     * @param month
     */
    List<UserDetailAndResignationDto> export(String month);
}

