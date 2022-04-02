package com.xiaozheng.socialsecurity.service.bs;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.bs.BsUserEntity;

import java.util.Map;

/**
 * bs_用户
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-03-31 09:55:12
 */
public interface BsUserService extends IService<BsUserEntity> {

    PageUtils<BsUserEntity> queryPage(BsUserEntity bsUser, Map<String, Object> params);
}

