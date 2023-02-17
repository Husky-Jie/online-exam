package com.husky.service.impl;

import cn.hutool.core.codec.Base64;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.husky.common.JwtUtils;
import com.husky.dto.RegisterDto;
import com.husky.entity.Action;
import com.husky.entity.Page;
import com.husky.entity.Role;
import com.husky.entity.User;
import com.husky.enums.LoginTypeEnum;
import com.husky.enums.RoleEnum;
import com.husky.mapper.UserMapper;
import com.husky.qo.LoginQo;
import com.husky.service.ActionService;
import com.husky.service.PageService;
import com.husky.service.RoleService;
import com.husky.service.UserService;
import com.husky.vo.ActionVo;
import com.husky.vo.PageVo;
import com.husky.vo.RoleVo;
import com.husky.vo.UserInfoVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 16:03
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PageService pageService;

    @Autowired
    private ActionService actionService;

    @Override
    public User addUser(RegisterDto registerDto) {
        User user = new User();
        // 设置规范的用户名称
        String prefix = "user";
        String userName = prefix + "_" +registerDto.getMobile();
        user.setUserUsername(userName);
        // 设置默认头像
        user.setUserAvatar("http://d.lanrentuku.com/down/png/1904/business_avatar/8_avatar_2754583.png");
        // 设置默认用户描述
        user.setUserDescription("welcome to online exam system");
        // 设置用户邮箱，数据字段已经设置unique了，失败会异常
        user.setUserEmail(registerDto.getEmail());
        // 设置用户id
        user.setUserId(UUID.randomUUID().toString());
        // 设置用户昵称与用户名相同
        user.setUserNickname(user.getUserUsername());
        // 设置用户手机号，数据字段已经设置unique了，失败会异常
        user.setUserPhone(registerDto.getMobile());
        // 将密码进行Base64加密
        String password = registerDto.getPassword();
        user.setUserPassword(Base64.encode(password));
        // 默认新用户为学生类型，需要老师和学生身份地话需要管理员修改
        user.setUserRoleId(RoleEnum.STUDENT.getId());
        this.save(user);
        return user;
    }

    @Override
    public String queryNameOrEmail(LoginQo loginQo) {
        User user;
        if (LoginTypeEnum.USERNAME.getType().equals(loginQo.getLoginType())){
            LambdaQueryWrapper<User> queryWrapperUsername = new LambdaQueryWrapper<>();
            queryWrapperUsername.eq(User::getUserUsername, loginQo.getUserInfo());
            user = this.getOne(queryWrapperUsername);
        }else {
            LambdaQueryWrapper<User> queryWrapperEmail = new LambdaQueryWrapper<>();
            queryWrapperEmail.eq(User::getUserEmail, loginQo.getUserInfo());
            user = this.getOne(queryWrapperEmail);
        }
        if (user != null) {
            String userPassword = Base64.decodeStr(user.getUserPassword());
            log.info("用户请求参数的密码{}", loginQo.getPassword());
            log.info("数据库储存的密码{}", userPassword);
            // 如果密码相等地话说明认证成功,返回生成的token，有效期为一天
            if (loginQo.getPassword().equals(userPassword)) {
                return JwtUtils.getToken(user);
            }
        }
        return null;
    }

    @Override
    public UserInfoVo getUserDetail(String userId) {
        LambdaQueryWrapper<User> userQueryWrapper = new LambdaQueryWrapper<>();
        userQueryWrapper.eq(User::getUserId, userId);
        // 根据id获取用户信息
        User user = this.getOne(userQueryWrapper);
        UserInfoVo userInfoVo = new UserInfoVo();
        // 拷贝user对象的基本信息
        if (user == null) {
            return null;
        }
        BeanUtils.copyProperties(user, userInfoVo, "userPassword", "createTime", "updateTime");
        LambdaQueryWrapper<Role> roleQueryWrapper = new LambdaQueryWrapper<>();
        roleQueryWrapper.eq(Role::getRoleId, user.getUserRoleId());
        Role role = roleService.getOne(roleQueryWrapper);
        RoleVo roleVo = new RoleVo();
        if (role == null) {
            return null;
        }
        // 拷贝role对象信息
        BeanUtils.copyProperties(role, roleVo, "roleId", "rolePageIds");
        // 获取PageVo集合对每个对象进行改造
        List<PageVo> pageVoList = new ArrayList<>();
        // 获取pageId
        String[] pageIds = role.getRolePageIds().split("-");
        for (String pageId :
                pageIds) {
            LambdaQueryWrapper<Page> pageQueryWrapper = new LambdaQueryWrapper<>();
            pageQueryWrapper.eq(Page::getPageId, pageId);
            Page page = pageService.getOne(pageQueryWrapper);
            PageVo pageVo = new PageVo();
            if (page == null) {
                return null;
            }
            BeanUtils.copyProperties(page, pageVo, "pageId", "actionIds");
            List<ActionVo> actionVoList = new ArrayList<>();
            // 获取actionId
            String[] actionIds = page.getActionIds().split("-");
            for (String actionId :
                    actionIds) {
                LambdaQueryWrapper<Action> actionQueryWrapper = new LambdaQueryWrapper<>();
                actionQueryWrapper.eq(Action::getActionId, actionId);
                Action action = actionService.getOne(actionQueryWrapper);
                ActionVo actionVo = new ActionVo();
                if (action == null) {
                    return null;
                }
                BeanUtils.copyProperties(action, actionVo, "actionId");
                actionVoList.add(actionVo);
            }
            pageVo.setActionVoList(actionVoList);
            pageVoList.add(pageVo);
        }
        roleVo.setPageVoList(pageVoList);
        userInfoVo.setRoleVo(roleVo);
        return userInfoVo;
    }
}
