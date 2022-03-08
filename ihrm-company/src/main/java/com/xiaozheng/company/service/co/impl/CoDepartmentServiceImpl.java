package com.xiaozheng.company.service.co.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.company.dao.co.CoCompanyDao;
import com.xiaozheng.company.dao.co.CoDepartmentDao;
import com.xiaozheng.company.service.co.CoDepartmentService;
import com.xiaozheng.model.co.CoCompanyEntity;
import com.xiaozheng.model.co.CoDepartmentEntity;
import com.xiaozheng.model.dto.DepartmentListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("coDepartmentService")
public class CoDepartmentServiceImpl extends ServiceImpl<CoDepartmentDao, CoDepartmentEntity> implements CoDepartmentService {

    @Autowired
    private CoCompanyDao coCompanyDao;

    @Override
    public PageUtils<CoDepartmentEntity> page(Map<String, Object> params) {
        IPage<CoDepartmentEntity> page = this.page(
                new Query<CoDepartmentEntity>().getPage(params),
                new QueryWrapper<CoDepartmentEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils<CoDepartmentEntity> queryPage(CoDepartmentEntity coDepartment, Map<String, Object> params) {
        IPage<CoDepartmentEntity> page = this.page(
                new Query<CoDepartmentEntity>().getPage(params),
                Wrappers.query(coDepartment)
        );
        return new PageUtils(page);
    }

    /**
     * 通过企业ID查询部门列表
     *
     * @param departmentId 主键
     * @return 单条数据
     */
    @Override
    public DepartmentListDto getDepartmentList(String departmentId) {

        DepartmentListDto departmentListDto = new DepartmentListDto();
        CoCompanyEntity coCompanyEntity = coCompanyDao.selectById(departmentId);
        departmentListDto.setCompanyId(departmentId);
        departmentListDto.setCompanyName(coCompanyEntity.getName());
        departmentListDto.setCompanyManage(coCompanyEntity.getLegalRepresentative());
        List<CoDepartmentEntity> coDepartmentEntities = baseMapper.selectList(Wrappers.<CoDepartmentEntity>lambdaQuery().eq(CoDepartmentEntity::getCompanyId, departmentId));
        departmentListDto.setDepartments(coDepartmentEntities);

        return departmentListDto;
    }

}