package com.husky.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/16
 * Time: 16:22
 */
@Data
@ApiModel("UserVo")
public class UserVo {

    private String userId;
    private String userUsername;
    private String userNickname;
    private Integer userRoleId;
    private String userAvatar;
    private String userDescription;
    private String userEmail;
    private String userPhone;
}
