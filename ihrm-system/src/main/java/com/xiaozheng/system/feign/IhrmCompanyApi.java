package com.xiaozheng.system.feign;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.model.co.CoDepartmentEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.feignapi.api
 * @ClassName: IhrmSystemApi
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/10 23:56
 */
@FeignClient("ihrm-company")
public interface IhrmCompanyApi {
    /**
     * 根据companyId和departmentCode获取部门信息
     * 参数为空查询所有
     *
     * @param companyId
     * @param departmentCode
     * @return
     */
    @ApiOperation("根据companyId和departmentCode获取部门信息")
    @PostMapping(value = "/co/department/CompanyIdAndDepartmentCode")
    R<List<CoDepartmentEntity>> querByCompanyIdAndDepartmentCode(@RequestParam("companyId") String companyId,@RequestParam(value = "departmentCode",required = false) String departmentCode);
}