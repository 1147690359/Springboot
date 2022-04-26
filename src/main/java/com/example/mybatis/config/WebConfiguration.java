package com.example.mybatis.config;

import com.example.mybatis.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 跨域请求支持/token拦截
 * tip:只能写在一个配置类里
 */
@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    private TokenInterceptor tokenInterceptor;

    //构造方法
    public WebConfiguration(TokenInterceptor tokenInterceptor){
        this.tokenInterceptor = tokenInterceptor;
    }





    @Override
    public void addInterceptors(InterceptorRegistry registry){
        List<String> excludePath = new ArrayList<>();
        //排除拦截//登录
        excludePath.add("/user/login");     //注册
        excludePath.add("/static/**");  //静态资源
        excludePath.add("/assets/**");  //静态资源
        excludePath.add("/index");
        excludePath.add("/static/images/**");
        excludePath.add("/image/*");


        InterceptorRegistration interceptorRegistration = registry.addInterceptor(tokenInterceptor);
        // 拦截地址
        interceptorRegistration.addPathPatterns("/**");
        // 排除地址
        interceptorRegistration.excludePathPatterns(excludePath);
    }
}