package com.cn.config;

import com.cn.filter.AuthFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossConfig implements WebMvcConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(CrossConfig.class);

    @Autowired
    private AuthFilter authFilter;


    /**
     * 添加自定义拦截器
     * 添加拦截路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authFilter).addPathPatterns("/userDetail/**");
    }
}