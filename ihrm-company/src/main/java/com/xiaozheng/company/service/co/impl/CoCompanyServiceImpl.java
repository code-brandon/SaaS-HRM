package com.xiaozheng.company.service.co.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaozheng.common.utils.IdWorker;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.common.utils.Query;
import com.xiaozheng.company.dao.co.CoCompanyDao;
import com.xiaozheng.company.service.co.CoCompanyService;
import com.xiaozheng.model.co.CoCompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("coCompanyService")
public class CoCompanyServiceImpl extends ServiceImpl<CoCompanyDao, CoCompanyEntity> implements CoCompanyService {


    @Autowired
    private CoCompanyDao companyDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public PageUtils<CoCompanyEntity> page(Map<String, Object> params) {
        IPage<CoCompanyEntity> page = this.page(
                new Query<CoCompanyEntity>().getPage(params),
                new QueryWrapper<CoCompanyEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils<CoCompanyEntity> queryPage(CoCompanyEntity coCompany, Map<String, Object> params) {
        IPage<CoCompanyEntity> page = this.page(
                new Query<CoCompanyEntity>().getPage(params),
                Wrappers.query(coCompany)
        );
        return new PageUtils(page);
    }

    /**
     * 保存企业
     * 1.配置idwork到工程
     * 2.在service中注入idwork
     * 3.通过idwork生成id
     * 4.保存企业
     */
    @Override
    public void add(CoCompanyEntity company) {
        //基本属性的设置
        String id = idWorker.nextId() + "";
        company.setId(id);
        //默认的状态
        company.setAuditState("0");//0：未审核，1：已审核
        company.setState(1); //0.未激活，1：已激活
        companyDao.insert(company);
    }

    /**
     * 更新企业
     * 1.参数：Company
     * 2.根据id查询企业对象
     * 3.设置修改的属性
     * 4.调用dao完成更新
     */
    @Override
    public void update(CoCompanyEntity company) {
        CoCompanyEntity temp = companyDao.selectById(company.getId());
        temp.setName(company.getName());
        temp.setCompanyPhone(company.getCompanyPhone());
        companyDao.insert(temp);
    }


    /**
     * 删除企业
     */
    @Override
    public void deleteById(String id) {
        companyDao.deleteById(id);
    }

    /**
     * 根据id查询企业
     */
    @Override
    public CoCompanyEntity findById(String id) {
        return companyDao.selectById(id);
    }

    /**
     * 查询企业列表
     */
    @Override
    public List<CoCompanyEntity> findAll() {
        return companyDao.selectList(new QueryWrapper<CoCompanyEntity>());
    }
}
