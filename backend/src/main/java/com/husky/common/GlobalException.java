package com.husky.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/1
 * Time: 15:36
 */
@Slf4j
@ResponseBody
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalException {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ApiResult<String> exceptionHandler(SQLIntegrityConstraintViolationException sqlEx){
        String[] split = sqlEx.getMessage().split(" ");
        if (sqlEx.getMessage().contains("for key 'user.user_email'")){
            String err = split[2] + "该邮箱已存在";
            log.info("{},该邮箱已存在",err);
            // return ApiResult.error(err);
        }else if (sqlEx.getMessage().contains("for key 'user.user_phone'")){
            String err = split[2] + "该手机号已存在";
            log.info("{},该手机号已存在",err);
            return ApiResult.error(err);
        }
        return ApiResult.error("系统繁忙，请稍后。。。");
    }

    @ExceptionHandler(CustomException.class)
    public ApiResult<String> registerException(CustomException customException){
        return ApiResult.error(customException.getMessage());
    }
}
