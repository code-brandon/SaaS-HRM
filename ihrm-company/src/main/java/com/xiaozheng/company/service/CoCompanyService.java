package com.xiaozheng.company.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaozheng.common.utils.PageUtils;
import com.xiaozheng.model.co.CoCompanyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author 小政同学 QQ:xiaozheng666888@qq.com
 * @email 1911298402@qq.com
 * @date 2022-02-08 13:48:37
 */
public interface CoCompanyService extends IService<CoCompanyEntity> {

    PageUtils<CoCompanyEntity> page(Map<String, Object> params);

    PageUtils<CoCompanyEntity> queryPage(CoCompanyEntity coCompany, Map<String, Object> params);

    void add(CoCompanyEntity company);

    void update(CoCompanyEntity company);

    void deleteById(String id);

    CoCompanyEntity findById(String id);

    List<CoCompanyEntity> findAll();
}

