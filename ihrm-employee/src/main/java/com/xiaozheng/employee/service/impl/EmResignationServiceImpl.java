package com.xiaozheng.employee.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.employee.dao.EmResignationDao;
import com.xiaozheng.employee.service.EmResignationService;
import com.xiaozheng.model.em.EmPositiveEntity;
import com.xiaozheng.model.em.EmResignationEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-10 12:00:08
 */
@Service("emResignationService")
public class EmResignationServiceImpl extends ServiceImpl<EmResignationDao, EmResignationEntity> implements EmResignationService {

    @Override
    public PageUtils<EmResignationEntity> queryPage(EmResignationEntity emResignation,Map<String, Object> params) {
        IPage<EmResignationEntity> page = this.page(
                new Query<EmResignationEntity>().getPage(params),
                Wrappers.query(emResignation)
        );
        return new PageUtils(page);
    }

    /**
     * 保存或更新数据
     *
     * @param emResignation 实体对象
     * @return 保存或更新数据结果
     */
    @Override
    public boolean updateOrSave(EmResignationEntity emResignation) {
        return this.saveOrUpdate(emResignation, new UpdateWrapper<EmResignationEntity>().eq("user_id", emResignation.getUserId()));
    }

}