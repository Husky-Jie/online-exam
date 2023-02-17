package com.husky.common;

import com.husky.entity.User;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/15
 * Time: 10:15
 */
public class JwtUtils {

    // 构建token的主题 自定义
    private static final String SUBJECT = "Husky";

    // 设置过期时间
    private static final long EXPIRE = 1000 * 60 * 60 * 24;

    // Jwt签名 自定义
    private static final String SIGNATURE = "Husky-jie";

    // 生成token
    public static String getToken(User user){
        if (user == null || user.getUserId() == null || user.getUserUsername() == null || user.getUserAvatar() == null){
            return null;
        }
        /*
        * builder()：构建Jwt
        * setSubject(SUBJECT)：设置主题，自定义*/
        return Jwts.builder().setSubject(SUBJECT)
                /* payload 通常⽤来存放⽤⼾信息
                 * 下面3行设置token中间字段，携带用户的信息
                 * */
                .claim("userId", user.getUserId())
                .claim("userName", user.getUserUsername())
                .claim("userAvatar", user.getUserAvatar())
                .setIssuedAt(new Date())
                // 设置过期时间
                .setExpiration(new Date(System.currentTimeMillis()+EXPIRE))
                //signature 签名值
                .signWith(SignatureAlgorithm.HS256, SIGNATURE)
                /*
                * compact()用来拼接以下三个值：
                * header可以不写，有默认值
                * payload
                * signature*/
                .compact();
    }

    // 校验token
    public static Claims checkJwt(String token){
        try {
            /*Jwts.parser()解密
            * setSigningKey(签名) 通过签名解密
            * parseClaimsJwt(token) 需要解密的token
            * getBody()获取Claims对象，该对象封装了用户的信息*/
            return Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            // 若篡改token会导致校验失败，走到异常分支，这里返回null
            return null;
        }
    }
}
