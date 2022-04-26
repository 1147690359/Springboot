package com.example.mybatis.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebImgConfig implements WebMvcConfigurer {


        @Value("${file.upload.dir}")
        private String uploadFolder;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("file:"+System.getProperty("user.dir")+uploadFolder);
        registry.addResourceHandler("/static/images/**").addResourceLocations("file:"+System.getProperty("user.dir")+uploadFolder);
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }


}
