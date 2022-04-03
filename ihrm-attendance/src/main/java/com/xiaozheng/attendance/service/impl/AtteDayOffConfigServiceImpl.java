package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteDayOffConfigDao;
import com.xiaozheng.attendance.service.AtteDayOffConfigService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.atte.AtteDayOffConfigEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 调休配置表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteDayOffConfigService")
public class AtteDayOffConfigServiceImpl extends ServiceImpl<AtteDayOffConfigDao, AtteDayOffConfigEntity> implements AtteDayOffConfigService {

    @Override
    public PageUtils<AtteDayOffConfigEntity> queryPage(AtteDayOffConfigEntity atteDayOffConfig,Map<String, Object> params) {
        IPage<AtteDayOffConfigEntity> page = this.page(
                new Query<AtteDayOffConfigEntity>().getPage(params),
                Wrappers.query(atteDayOffConfig)
        );
        return new PageUtils(page);
    }

}