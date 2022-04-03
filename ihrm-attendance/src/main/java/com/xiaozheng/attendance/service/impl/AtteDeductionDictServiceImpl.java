package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteDeductionDictDao;
import com.xiaozheng.attendance.service.AtteDeductionDictService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteDeductionDictEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 扣款字典表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteDeductionDictService")
public class AtteDeductionDictServiceImpl extends ServiceImpl<AtteDeductionDictDao, AtteDeductionDictEntity> implements AtteDeductionDictService {

    @Override
    public PageUtils<AtteDeductionDictEntity> queryPage(AtteDeductionDictEntity atteDeductionDict,Map<String, Object> params) {
        IPage<AtteDeductionDictEntity> page = this.page(
                new Query<AtteDeductionDictEntity>().getPage(params),
                Wrappers.query(atteDeductionDict)
        );
        return new PageUtils(page);
    }

}