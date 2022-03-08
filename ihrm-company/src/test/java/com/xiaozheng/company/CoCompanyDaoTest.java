package com.xiaozheng.company;

import com.xiaozheng.common.utils.JwtUtils;
import com.xiaozheng.company.dao.co.CoCompanyDao;
import com.xiaozheng.system.dao.pe.PeUserRoleDao;
import com.xiaozheng.model.co.CoCompanyEntity;
import com.xiaozheng.model.pe.PeUserRoleEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class CoCompanyDaoTest {
    @Autowired
    private CoCompanyDao companyDao;

    @Autowired
    private PeUserRoleDao peUserRoleDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Test
    public void test() {

        //save(company) ;  保存或更新（id）
        //deleteByIid); 根据id删除
        //findById（id）；根据id查询
        //findAll() 查询全部

        CoCompanyEntity company = companyDao.selectById("1");
        System.out.println(company);
    }

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void test1() throws Exception {
        String userId = "1111111111111111111";
        PeUserRoleEntity peUserRoleEntity = new PeUserRoleEntity();
        for (int i = 10000; i < 10010; i++) {
            peUserRoleEntity.setUserId(userId);
            peUserRoleEntity.setRoleId(i+"");
            if (i == 10005) {
                // throw new CommonException(ResultCode.FAIL);
                peUserRoleEntity.setRoleId(null);
            }
            peUserRoleDao.insert(peUserRoleEntity);
            System.out.println("peUserRoleEntity = " + peUserRoleEntity);
        }
    }

    @Test
    public void test3() {
        System.out.println(jwtUtils.getKey());
    }
}

