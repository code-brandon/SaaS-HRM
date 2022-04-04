package com.xiaozheng.attendance.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.attendance.dao.AtteAttendanceConfigDao;
import com.xiaozheng.attendance.service.AtteAttendanceConfigService;
import com.xiaozheng.common.entity.PeUserDto;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.common.utils.ShiroContextUtils;
import com.xiaozheng.model.atte.AtteAttendanceConfigEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 考勤配置表实现
 *
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-04-03 22:50:30
 */
@Service("atteAttendanceConfigService")
public class AtteAttendanceConfigServiceImpl extends ServiceImpl<AtteAttendanceConfigDao, AtteAttendanceConfigEntity> implements AtteAttendanceConfigService {

    @Override
    public PageUtils<AtteAttendanceConfigEntity> queryPage(AtteAttendanceConfigEntity atteAttendanceConfig,Map<String, Object> params) {
        IPage<AtteAttendanceConfigEntity> page = this.page(
                new Query<AtteAttendanceConfigEntity>().getPage(params),
                Wrappers.query(atteAttendanceConfig)
        );
        return new PageUtils(page);
    }

    /**
     * 通过部门ID和企业ID查询考勤配置
     * @param departmentId 部门ID
     * @return
     */
    @Override
    public AtteAttendanceConfigEntity getByDeptIdAndcompanyId(String departmentId) {
        String companyId = ShiroContextUtils.getProfile().getCompanyId();
        return baseMapper.selectOne(Wrappers.lambdaQuery(AtteAttendanceConfigEntity.class).eq(AtteAttendanceConfigEntity::getDepartmentId, departmentId).eq(AtteAttendanceConfigEntity::getCompanyId, companyId));
    }

    /**
     * 保存或修改企业考勤设置
     *
     * @param atteAttendanceConfig 实体对象
     * @return 修改结果
     */
    @Override
    public boolean updateOrSave(AtteAttendanceConfigEntity atteAttendanceConfig) {
        PeUserDto profile = ShiroContextUtils.getProfile();
        atteAttendanceConfig.setCompanyId(profile.getCompanyId());
        atteAttendanceConfig.setUpdateBy(profile.getId());
        // TODO 该处日期需要置为空,否则日期不进行更新填充
        atteAttendanceConfig.setUpdateDate(null);
        return this.saveOrUpdate(atteAttendanceConfig,
               Wrappers.<AtteAttendanceConfigEntity>lambdaUpdate()
                        .eq(AtteAttendanceConfigEntity::getDepartmentId, atteAttendanceConfig.getDepartmentId()));
    }

}