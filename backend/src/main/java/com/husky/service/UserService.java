package com.husky.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.husky.dto.RegisterDto;
import com.husky.entity.User;
import com.husky.qo.LoginQo;
import com.husky.vo.UserInfoVo;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 16:02
 */
public interface UserService extends IService<User> {

    // 添加用户
    User addUser(RegisterDto registerDto);

    // 根据账户名或邮箱查询用户，登录成功返回token
    String queryNameOrEmail(LoginQo loginQo);

    // 获取用户详细信息
    UserInfoVo getUserDetail(String userId);
}
