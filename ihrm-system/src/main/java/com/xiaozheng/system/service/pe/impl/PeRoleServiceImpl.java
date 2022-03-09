package com.xiaozheng.system.service.pe.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.model.dto.PeRoleDto;
import com.xiaozheng.model.pe.PeRoleEntity;
import com.xiaozheng.system.dao.pe.PeRoleDao;
import com.xiaozheng.system.service.pe.PeRoleService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-10 22:47:03
 */
@Service("peRoleService")
public class PeRoleServiceImpl extends ServiceImpl<PeRoleDao, PeRoleEntity> implements PeRoleService {

    @Override
    public PageUtils<PeRoleEntity> queryPage(PeRoleEntity peRole, Map<String, Object> params) {
        IPage<PeRoleEntity> page = this.page(
                new Query<PeRoleEntity>().getPage(params),
                Wrappers.query(peRole)
        );
        return new PageUtils(page);
    }

    /**
     * 通过主键查询单条数据和所关联权限
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public PeRoleDto infoAndPermById(String id) {
        return baseMapper.infoAndPermById(id);
    }

}