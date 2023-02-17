package com.husky.controller;

import com.husky.common.ApiResult;
import com.husky.enums.ResultEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 16:11
 */
@RestController
@RequestMapping("/api/auth")
public class UserLogoutController {

    @PostMapping("/logout")
    public ApiResult<String> logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("userName");
        return ApiResult.success(ResultEnum.LOGOUT_SUCCESS.getCode(), ResultEnum.LOGOUT_SUCCESS.getMessage(), null);
    }
}
