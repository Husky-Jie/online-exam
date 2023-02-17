package com.husky.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 15:57
 */
@Data
@ApiModel("UserInfoVo")
public class UserInfoVo {

    @JsonProperty("id")
    private String userId;

    @JsonProperty("avatar")
    private String userAvatar;

    @JsonProperty("name")
    private String userNickname;

    @JsonProperty("username")
    private String userUsername;

    /**
     * 密码不用拷贝，免得泄露信息
     */
    private String password = "";

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("telephone")
    private String userPhone;

    @JsonProperty("roleId")
    private String roleName;

    @JsonProperty("welcome")
    private String userDescription;

    @JsonProperty("role")
    private RoleVo roleVo;
}
