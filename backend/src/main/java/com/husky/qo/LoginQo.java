package com.husky.qo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/13
 * Time: 10:42
 */
@Data
@ApiModel("loginQo")
public class LoginQo {

    private Integer loginType;
    private String password;
    private String userInfo;
}
