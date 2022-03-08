package com.xiaozheng.common.handler;

import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import com.xiaozheng.common.exception.CommonException;
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
public class BaseExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public R error(HttpServletRequest request, HttpServletResponse response, Exception e) {
        System.out.println(e.getMessage());
        if(e.getClass() == CommonException.class) {
            //类型转型
            CommonException ce = (CommonException) e;
            R result = new R(ce.getResultCode().code(),ce.getResultCode().message(),ce.getMessage());
            return result;
        }else{
            R result = new R(ResultCode.SERVER_ERROR.code(),ResultCode.SERVER_ERROR.message(),e.getMessage());
            return result;
        }
    }
}
