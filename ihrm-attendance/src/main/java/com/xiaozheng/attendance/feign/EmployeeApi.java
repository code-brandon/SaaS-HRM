package com.xiaozheng.attendance.feign;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.model.em.EmUserCompanyPersonalEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.attendance.feign
 * @ClassName: EmployeeApi
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/4 23:11
 */
@FeignClient("ihrm-employee")
public interface EmployeeApi {
    /**
     * 根据手机ID集合查询用户信息
     *
     * @param mobiles
     * @return
     */
    @ApiOperation("根据手机ID集合查询用户信息")
    @PostMapping("/em/personal/infosBymobile")
    R<List<EmUserCompanyPersonalEntity>> getByMobile(@RequestBody Set<String> mobiles);
}
