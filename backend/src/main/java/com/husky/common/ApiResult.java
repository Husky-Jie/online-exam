package com.husky.common;

import io.swagger.annotations.ApiModel;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/28
 * Time: 16:24
 */
@Data
public class ApiResult<T> implements Serializable {

    private static final long serialVersionUID = -2344852857577155975L;
    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    public static <T> ApiResult<T> success(Integer code, String msg, T object) {
        ApiResult<T> r = new ApiResult<T>();
        r.data = object;
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static <T> ApiResult<T> error(Integer code, String msg, T object) {
        ApiResult<T> r = new ApiResult<T>();
        r.data = object;
        r.code = code;
        r.msg = msg;
        return r;
    }

    public static <T> ApiResult<T> error(String msg) {
        ApiResult r = new ApiResult();
        r.msg = msg;
        r.code = 1;
        return r;
    }
}
