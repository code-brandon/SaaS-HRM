package com.xiaozheng.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.zuul.filter
 * @ClassName: LoginFilter
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/11 12:34
 */
// @Configuration
public class LoginFilter extends ZuulFilter {
    /**
     * 按类型对过滤器进行分类。 Zuul 中的标准类型是“pre”，用于预路由过滤，
     * "route" 用于路由到源，"post" 用于路由后过滤器，"error" 用于错误处理。
     * 我们还支持静态响应的“static”类型，请参阅 StaticResponseFilter。
     * 通过调用 FilterProcessor.runFilters(type) 创建或添加并运行任何 filterType
     *
     * @return A String representing that type
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 还必须为过滤器定义 filterOrder()。如果优先级不同，过滤器可能具有相同的 filterOrder
     * 对过滤器很重要。 filterOrders 不需要是顺序的。
     * 数字越小 优先级越高
     * @return 过滤器的 int 顺序
     */
    @Override
    public int filterOrder() {
        return 2;
    }

    /**
     * 此方法的“真”返回意味着应该调用 run() 方法
     *
     * @return 如果应该调用 run() 方法，则为 true。 false 不会调用 run() 方法
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 如果 shouldFilter() 为真，将调用此方法。这个方法是一个ZuulFilter的核心方法
     *
     * @return Some arbitrary artifact may be returned. Current implementation ignores it.
     * @throws ZuulException if an error occurs during execution.
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();

        HttpServletRequest request = currentContext.getRequest();
        String authorization = request.getHeader("Authorization");
        if(StringUtils.isEmpty(authorization)) {
            //如果没有携带，拦截
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }else {
            //请求头信息：bearer sessionid
            authorization = authorization.replaceAll("Bearer ", "");
        }
        System.out.println("authorization = " + authorization);
        return null;
    }
}
