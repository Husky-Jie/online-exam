package com.husky.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.husky.entity.User;
import com.husky.qo.LoginQo;
import org.apache.ibatis.annotations.Select;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/1/29
 * Time: 16:01
 */
public interface UserMapper extends BaseMapper<User> {
}
