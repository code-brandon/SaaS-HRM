package com.xiaozheng.common.handler;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的公共异常处理器
 *      1.声明异常处理器
 *      2.对异常统一处理
 */
@ControllerAdvice
@Slf4j
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R<String> error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        log.error("公共异常处理器:{}",e.getMessage());
        if(e.getClass() == CommonException.class) {
            //类型转型
            CommonException ce = (CommonException) e;
            return new R(ce.getResultCode().code(),ce.getResultCode().message(),ce.getMessage());
        }else{
            return new R(ResultCode.SERVER_ERROR.code(),ResultCode.SERVER_ERROR.message(),e.getMessage());
        }
    }

    @ExceptionHandler(value = AuthorizationException.class)
    @ResponseBody
    public R<String> error(HttpServletRequest request, HttpServletResponse response, AuthorizationException e) {
        log.error("公共异常处理器:{}",e.getMessage());
        return new R(ResultCode.SERVER_ERROR.code(),ResultCode.SERVER_ERROR.message(),e.getMessage());
    }
}
