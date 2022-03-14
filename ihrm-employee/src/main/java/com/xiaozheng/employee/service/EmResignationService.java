package com.xiaozheng.employee.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.em.EmResignationEntity;

import java.util.Map;

/**
 * 
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
public interface EmResignationService extends IService<EmResignationEntity> {

    PageUtils<EmResignationEntity> queryPage(EmResignationEntity emResignation, Map<String, Object> params);


    /**
     * 保存或更新数据
     * @param emResignation 实体对象
     * @return 保存或更新数据结果
     */
    boolean updateOrSave(EmResignationEntity emResignation);
}

