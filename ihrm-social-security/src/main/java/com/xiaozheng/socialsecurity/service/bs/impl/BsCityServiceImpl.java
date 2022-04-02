package com.xiaozheng.socialsecurity.service.bs.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.bs.BsCityEntity;
import com.xiaozheng.socialsecurity.dao.bs.BsCityDao;
import com.xiaozheng.socialsecurity.service.bs.BsCityService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * bs_城市实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@Service("bsCityService")
public class BsCityServiceImpl extends ServiceImpl<BsCityDao, BsCityEntity> implements BsCityService {

    @Override
    public PageUtils<BsCityEntity> queryPage(BsCityEntity bsCity, Map<String, Object> params) {
        IPage<BsCityEntity> page = this.page(
                new Query<BsCityEntity>().getPage(params),
                Wrappers.query(bsCity)
        );
        return new PageUtils(page);
    }

}