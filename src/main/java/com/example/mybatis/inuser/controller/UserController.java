package com.example.mybatis.inuser.controller;

import com.example.mybatis.inuser.service.UserServiceimp;
import com.example.mybatis.inuser.user.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {


    @Resource
    private UserServiceimp userServiceimp;



    /*
     * GET-获取用户
     * DELETE-删除用户
     * PUT-修改用户
     * POST-保存用户
     */

    /**
     * 加载数据表中数据
     * 查询 表中的所有信息
     * @return 返回查询到的所有数据
     */
    @GetMapping("/user")
    public List<User> user(){
        return userServiceimp.userBy();
    }


    /**
     * 模糊查询
     * @return 返回一个查询到的集合存放sql中的数据
     */
    @GetMapping("/selectByName")
    public List<User> selectByName(@PathParam("selectByName") User user){
        return userServiceimp.selectByName(user);
    }


    /**
     * 根据id 删除表中的数据
     */
    @DeleteMapping("/userDelete/{id}")
    public Map<String, Object> delete(@PathVariable("id") int id ){
        return userServiceimp.delete(id);
    }


    /**
     * 添加功能
     */
    @RequestMapping("/insertUser")
    public Map<String, Object> insertUser(@RequestBody User user){
        return userServiceimp.insertUser(user);
    }

    /**
     * 修改功能
     *
     */
    @PutMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user){
        return userServiceimp.updateUser(user);
    }

    /**
     * 账号登录
     */
    @PostMapping("/index")
    public Map<String, Object> index(@RequestBody User user){
        return userServiceimp.index(user);
    }


    @GetMapping("/hell")
    public String hell(){
        return "hell";
    }





}