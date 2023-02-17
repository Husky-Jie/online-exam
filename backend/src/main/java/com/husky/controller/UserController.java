package com.husky.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.husky.common.ApiResult;
import com.husky.dto.RegisterDto;
import com.husky.entity.User;
import com.husky.enums.ResultEnum;
import com.husky.qo.LoginQo;
import com.husky.service.UserService;
import com.husky.vo.UserInfoVo;
import com.husky.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 16:41
 */
@Api("用户相关接口")
@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    @ApiOperation("账号注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userRegister", value = "注册参数", dataType = "RegisterDto")
    })
    public ApiResult<User> userRegister(@RequestBody RegisterDto registerDto){
        User res = userService.addUser(registerDto);
        if (res != null) {
            return ApiResult.success(ResultEnum.REGISTER_SUCCESS.getCode(), ResultEnum.REGISTER_SUCCESS.getMessage(), res);
        }else {
            return ApiResult.success(ResultEnum.REGISTER_FAILED.getCode(), ResultEnum.REGISTER_FAILED.getMessage(), null);
        }
    }

    @PostMapping("/login")
    @ApiOperation("根据用户名或邮箱登录,登录成功返回token")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userLogin", value = "登录参数", dataType = "LoginQo")
    })
    public ApiResult<String> userLogin(@RequestBody LoginQo loginQo){
        String token = userService.queryNameOrEmail(loginQo);
        if (token != null) {
            return ApiResult.success(ResultEnum.LOGIN_SUCCESS.getCode(), ResultEnum.LOGIN_SUCCESS.getMessage(), token);
        }else {
            return ApiResult.error(ResultEnum.LOGIN_FAILED.getCode(), ResultEnum.LOGIN_FAILED.getMessage(), null);
        }
    }

    @GetMapping("/info")
    @ApiOperation("获取用户的详细信息，包括个人信息页面和操作权限")
    public ApiResult<UserInfoVo> infoVo (HttpServletRequest request){
        log.info("获取用户详细信息，包括个人信息页面和操作权限");
        String userId = (String) request.getAttribute("userId");
        UserInfoVo userInfoVo = userService.getUserDetail(userId);
        return ApiResult.success(ResultEnum.GET_INFO_SUCCESS.getCode(), ResultEnum.GET_INFO_SUCCESS.getMessage(), userInfoVo);
    }

    @GetMapping("/user-info")
    @ApiOperation("获取用户信息")
    public ApiResult<UserVo> userInfo(HttpSession session){
        String userId = (String) session.getAttribute("userId");
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserId, userId);
        User user = userService.getOne(queryWrapper);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo, "userPassword", "createTime", "updateTime");
        return ApiResult.success(ResultEnum.GET_INFO_SUCCESS.getCode(), ResultEnum.GET_INFO_SUCCESS.getMessage(), userVo);
    }
}
