package com.xiaozheng.common.config;

import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import com.xiaozheng.common.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * What --
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.common.config
 * @ClassName: JwtInterceptorHander
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/3/8 15:33
 */
// @Component
public class JwtInterceptorHandler extends HandlerInterceptorAdapter {

    // @Autowired
    private JwtUtils jwtUtils;

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 从请求头中获取token
         */
        String authorization = request.getHeader("Authorization");
        if (StringUtils.isEmpty(authorization) && !authorization.startsWith("Bearer ")) {
            throw new CommonException(ResultCode.UNAUTHENTICATED);
        }
        String token = authorization.replace("Bearer ", "");
        System.out.println("token = " + token);
        Claims claims = jwtUtils.parseJwt(token);
        if (Objects.nonNull(claims)) {
            //通过claims获取到当前用户的可访问API权限字符串
            String apis = (String) claims.get("apis");  //api-user-delete,api-user-update
            //通过handler
            HandlerMethod h = (HandlerMethod) handler;
            //获取接口上的reqeustmapping注解
            RequestMapping annotation = h.getMethodAnnotation(RequestMapping.class);
            //获取当前请求接口中的name属性
            String name = annotation.name();
            //判断当前用户是否具有响应的请求权限
            if(apis.contains(name)) {
                request.setAttribute("user_claims",claims);
                return true;
            }else {
                throw new CommonException(ResultCode.UNAUTHORISE);
            }
        }
        throw new CommonException(ResultCode.UNAUTHENTICATED);
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * This implementation is empty.
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
