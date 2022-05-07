package com.example.mybatis.home.controller;


import com.example.mybatis.home.service.HomeService;
import com.example.mybatis.home.user.NumUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class HomeController {

    @Resource
    private HomeService homeService;

    @GetMapping("/number")
    public void Num(){
         homeService.Num();
    }
}
