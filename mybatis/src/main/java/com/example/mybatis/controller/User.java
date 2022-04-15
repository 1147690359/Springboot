package com.example.mybatis.controller;


import com.example.mybatis.userbean.service.UserServiceimp;
import com.example.mybatis.userbean.user.Userbean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@CrossOrigin
@RestController
public class User {


    @Resource
    private UserServiceimp userServiceimp;


    /**
     *
     *
     * vue 发来请求index请求
     * @RequestBody 接受vue发来的数据 （form）
     * 接收跨域发来的数据 还要有个注解@CrossOrigin
     * @param userbean
     * @return
     */

    @RequestMapping("/index")
    public Map aaa(@RequestBody Userbean userbean){
        return userServiceimp.user(userbean);

    }



    /**
     * GET-获取用户
     * DELETE-删除用户
     * PUT-修改用户
     * POST-保存用户
     */

    /**
     * 查询 表中的所有信息
     * @return
     */
    @GetMapping("/user")
    public List user(){
        return userServiceimp.userBy();
    }

    /**
     * 根据id 删除数据
     * @return  影响行数
     */
    @DeleteMapping("/dele")
    public int delete(@RequestBody Userbean userbean){
        return userServiceimp.delete(userbean);
    }

    /**
     * 向 t_user 中添加 账号密码
     * @param
     * @return
     */
    @PostMapping("ins")
    public int ins (@RequestBody Userbean userbean){
        return userServiceimp.insert(userbean);
    }

    @PutMapping("/update")
    public int update (@RequestBody Userbean userbean){
        return userServiceimp.update(userbean);
    }






}