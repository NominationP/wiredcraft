package com.cn.filter;


import com.cn.dto.AppContext;
import com.cn.entity.UserDetail;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
public class AuthFilter implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthFilter.class);

    @Autowired
    ObjectMapper objectMapper;


    @Value("${spring.profiles.active}")
    private String envStr;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //Filter过滤器跨域处理
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");

        String userToken = request.getHeader("Authorization");
        userToken = userToken == null ? "" : userToken;

        String token = userToken.substring(userToken.lastIndexOf("bearer") + 7);
        Claims body = Jwts.parser()
                .setSigningKey("test_key".getBytes(StandardCharsets.UTF_8))//指定编码格式，要不然token有中文转换异常
                .parseClaimsJws(token)
                .getBody();
        /*
        {
        user_name=admin, scope=[all], exp=1640655682, authorities=[admin],
        jti=33e780cb-cd3c-4181-a7b3-30bd56201acd, client_id=client, enhance=enhanceInfo
         }
         todo parse above info to userDetail && change if condition
         */
        if(true){
            AppContext.getContext().setUserInfo(UserDetail.builder().id(1).name("bo").build());
            return true;
        }

        //重置response
        response.reset();
        //设置编码格式
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        PrintWriter pw = response.getWriter();

        ObjectNode res = objectMapper.createObjectNode();

        res.put("resultCode", "20001");
        res.put("resultMessage", "token失效");

        pw.write(res.toString());

        pw.flush();
        pw.close();
        return false;
    }
}
