package com.xiaozheng.feignapi.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

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
@FeignClient(contextId = "ihrmSystemApi",value = "ihrm-system")
public interface IhrmSystemApi {
    @GetMapping("/profileByMobile/{mobile}")
    Object profileByMobile(@PathVariable("mobile") String mobile, @RequestHeader(value = "x-Device") String al) throws Exception;
}
