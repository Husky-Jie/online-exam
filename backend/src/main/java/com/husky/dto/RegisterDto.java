package com.husky.dto;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 15:54
 */
@Data
@ApiModel("注册信息请求参数类")
public class RegisterDto {

    private String captcha;
    private String email;
    private String mobile;
    private String password;
    private String password2;
}
