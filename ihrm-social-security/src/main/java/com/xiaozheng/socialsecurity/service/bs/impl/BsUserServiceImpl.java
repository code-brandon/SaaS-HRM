package com.xiaozheng.socialsecurity.service.bs.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.bs.BsUserEntity;
import com.xiaozheng.socialsecurity.dao.bs.BsUserDao;
import com.xiaozheng.socialsecurity.service.bs.BsUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * bs_用户实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
@Service("bsUserService")
public class BsUserServiceImpl extends ServiceImpl<BsUserDao, BsUserEntity> implements BsUserService {

    @Override
    public PageUtils<BsUserEntity> queryPage(BsUserEntity bsUser, Map<String, Object> params) {
        IPage<BsUserEntity> page = this.page(
                new Query<BsUserEntity>().getPage(params),
                Wrappers.query(bsUser)
        );
        return new PageUtils(page);
    }

}