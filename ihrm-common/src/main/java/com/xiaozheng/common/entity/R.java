package com.xiaozheng.common.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Boy's
 */
@ApiModel("api通用返回数据")
@Data
@AllArgsConstructor
public class R<T> {

    //uuid,用作唯一标识符，供序列化和反序列化时检测是否一致

    /**
     * 标识代码，0表示成功，非0表示出错
     */
    @ApiModelProperty("标识代码,0表示成功，非0表示出错")
    private Integer code;

    /**
     * 提示信息
     */
    @ApiModelProperty("提示信息")
    private String message;

    /**
     * 正常返回时返回的数据
     */
    @ApiModelProperty("返回的数据")
    private T data;

    @ApiModelProperty("其他携带的数据")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private HashMap<String, Object> other = new HashMap<>();

    public R() {
    }

    public R(int code, String message, T data) {
        setCode(code);
        setMessage(message);
        data(data);
    }

    public static R error() {
        R r = new R();
        r.setCode(ResultCode.SERVER_ERROR.code);
        r.setMessage("未知异常，请联系管理员");
        return r;
    }

    public static R error(String message) {
        R r = error();
        r.setMessage(message);
        return r;
    }

    public static R error(int code, String message) {
        R r = error();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public static R ok(String message) {
        R r = ok();
        r.setMessage(message);
        return r;
    }

    public static R ok(int code, String message) {
        R r = ok();
        r.setCode(code);
        r.setMessage(message);
        return r;
    }

    public R otherAll(Map<String, Object> map) {
        R r = new R();
        r.other.putAll(map);
        return r;
    }

    public static R ok() {
        R r = new R();
        r.setCode(ResultCode.SUCCESS.code);
        r.setMessage(ResultCode.SUCCESS.message);
        return r;
    }

    public R other(String K, Object v) {
        other.put(K, v);
        return this;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public R data(String str,T data) {
        Map<String, T> hashMap = new HashMap<>();
        hashMap.put(str, data);
        this.setData((T) hashMap);
        return this;
    }
}