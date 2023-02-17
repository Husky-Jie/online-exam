package com.husky.interceptor;

import com.google.gson.Gson;
import com.husky.common.JsonData;
import com.husky.common.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: 周圣杰
 * Date: 2023/2/15
 * Time: 16:10
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    @Value("${interceptor.auth-ignore-uris}")
    private String authIgnoreUris;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("拦截器启动！！！");
        String uri = request.getRequestURI();
        String[] split = authIgnoreUris.split(",");
        // 登录和注册接口不需要进行token拦截和校验
        for (String uris :
                split) {
            if (uri.equals(uris)) {
                log.info("登录和注册接口不拦截！！！");
                return true;
            }
        }
        // 注意要和前端适配Access-Token属性，前端会在登陆后的每个接口请求头加Access-Token属性
        String token = request.getHeader("Access-Token");
        if (token == null){
            // token不在header中时，也可能在参数中(RequestParam)
            token = request.getParameter("token");
        }
        if (token != null) {
            // 获取token中的用户信息的claims对象
            Claims claims = JwtUtils.checkJwt(token);
            if (claims == null) {
                // 若claims为空对象，则说明token被纂改，校验失败
                sendJsonMessage(response, JsonData.buildError("token无效，请重新登录"));
                log.info("claims为空对象，则说明token被纂改，校验失败！！！");
                return false;
            }else {
                // 用户id
                String userId = (String) claims.get("userId");
                // 用户名
                String userName = (String) claims.get("userName");
                // 将用户信息存进session中，在controller中不用再次解密token获取用户信息
                request.setAttribute("userId", userId);
                request.setAttribute("userName", userName);
                log.info("将用户信息存进session中，不拦截！！！");
                return true;
            }
        }
        sendJsonMessage(response, JsonData.buildError("token为空，请重新登录"));
        log.info("token为空拦截！！！");
        return false;
    }

    public static void sendJsonMessage(HttpServletResponse response, Object obj) throws IOException {
        Gson gson = new Gson();
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.write(gson.toJson(obj));
        writer.close();
        writer.flush();
    }
}
