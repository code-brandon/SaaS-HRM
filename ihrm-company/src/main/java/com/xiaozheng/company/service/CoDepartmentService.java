package com.xiaozheng.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.co.CoDepartmentEntity;
import com.xiaozheng.model.dto.DepartmentListDto;

import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
public interface CoDepartmentService extends IService<CoDepartmentEntity> {

    PageUtils<CoDepartmentEntity> page(Map<String, Object> params);

    PageUtils<CoDepartmentEntity> queryPage(CoDepartmentEntity coDepartment, Map<String, Object> params);

    /**
     * 通过企业ID查询部门列表
     *
     * @param departmentId 主键
     * @return 单条数据
     */
    DepartmentListDto getDepartmentList(String departmentId);
}

