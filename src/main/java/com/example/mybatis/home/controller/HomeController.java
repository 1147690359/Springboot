package com.example.mybatis.home.controller;


import com.example.mybatis.home.service.HomeService;
import com.example.mybatis.home.user.NumUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
public class HomeController {

    @Resource
    private HomeService homeService;

    /**
     *访问的数量
     */
    @GetMapping("/number")
    public Map<String,Object> Num(){
         return homeService.Num();
    }

    /**
     *所有的日期对应的数量
     */
    @GetMapping("/numUser")
    public List<NumUser> select(){
        return homeService.select();
    }
}
