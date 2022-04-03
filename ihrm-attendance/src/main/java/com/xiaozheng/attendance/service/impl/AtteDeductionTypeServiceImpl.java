package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteDeductionTypeDao;
import com.xiaozheng.attendance.service.AtteDeductionTypeService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteDeductionTypeEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 扣款类型表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteDeductionTypeService")
public class AtteDeductionTypeServiceImpl extends ServiceImpl<AtteDeductionTypeDao, AtteDeductionTypeEntity> implements AtteDeductionTypeService {

    @Override
    public PageUtils<AtteDeductionTypeEntity> queryPage(AtteDeductionTypeEntity atteDeductionType,Map<String, Object> params) {
        IPage<AtteDeductionTypeEntity> page = this.page(
                new Query<AtteDeductionTypeEntity>().getPage(params),
                Wrappers.query(atteDeductionType)
        );
        return new PageUtils(page);
    }

}