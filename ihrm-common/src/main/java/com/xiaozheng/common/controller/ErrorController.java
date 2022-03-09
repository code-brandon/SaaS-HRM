package com.xiaozheng.common.controller;


import com.xiaozheng.common.entity.R;
import com.xiaozheng.common.entity.ResultCode;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ErrorController {

    //公共错误跳转
    @RequestMapping(value="autherror")
    public R<Boolean> autherror(int code) {
        return code ==1?R.error(ResultCode.UNAUTHENTICATED.code(),ResultCode.UNAUTHENTICATED.message()).data(false):R.error(ResultCode.UNAUTHORISE.code(),ResultCode.UNAUTHORISE.message()).data(false);
    }

}
