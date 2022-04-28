package com.example.mybatis.inuser.service;


import com.example.mybatis.imgCommon.service.ImgService;
import com.example.mybatis.inuser.mapper.UserMapper;

import com.example.mybatis.inuser.user.User;
import com.example.mybatis.util.SecurityUtils;
import com.example.mybatis.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimp  {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ImgService imgService;



    /**
     * 查询表中的所有信息
     * @return list 查询出来的所有信息
     */
    public List<User> userBy(){

        return userMapper.select();
    }


    public List<User> selectByName(User user){

        return userMapper.seleByName(user);
    }


    public Map<String, Object> delete(int id){
        int in = userMapper.delete(id);
        Map<String, Object> map=new HashMap<>();
        if (in == 0){
            map.put("del","null");
        }else {
            map.put("del","have");
        }
        return map;
    }


    public Map<String, Object> insertUser(User user){
        Map<String,Object > map=new HashMap<>();

        //查询有没有相同的用户名
        List<User> list=userMapper.selectName(user.getUsername());
        if(!list.isEmpty()){
            map.put("equ","equ");
            return map;
        }

        //获取注册的时间
        String format = "YYYY-MM-dd hh:mm:ss";
        // DateTimeFormatter.ofPattern方法根据指定的格式输出时间
        String formatDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
        //控制台 打印获取的时间
        System.out.println(formatDateTime);
        user.setDate(formatDateTime);

        //密码进行加密
        String encode = SecurityUtils.encodePassword(user.getPassword());
        user.setPassword(encode);

       //添加成功后返回的 影响的行数
        int in = userMapper.insertUser(user);
        if (in == 0){
            map.put("ins","null");
        }else {
            map.put("ins","have");
        }
        return map;
    }

    public Map<String, Object> updateUser(User user){
        Map<String,Object> map=new HashMap<>();

        //查询有没有相同的用户名
        String username=user.getUsername();
        String updateUsername=user.getUpdateUsername();
        if(!username.equals(updateUsername)){
            List<User> list=userMapper.selectName(user.getUsername());
            if(!list.isEmpty()){
                map.put("equ","equ");
                return map;
            }
        }


        int in = userMapper.updateUser(user);
        if (in == 0){
            map.put("update","null");
        }else {
            map.put("update","have");
        }
        return map;
    }


    public Map<String, Object> index(User user){
        Map<String,Object> map=new HashMap<>();

        //获取数据库中的密码
        String encode = userMapper.password(user.getUsername());
        if (encode == null){
            map.put("index","null");
            return map;
        }

        //数据库中的密码与 输入的密码进行判断
        boolean aa = SecurityUtils.matchesPassword(user.getPassword(), encode);

        System.out.println(aa);

        if(!aa){
            map.put("index",1);
            return map;
        }
        map.put("index","have");

        //获取图片的位置
            String imgUrl = userMapper.imgUrl(user);
            map.put("imgUrl",imgUrl);
       // 签发的Token
            String token= TokenUtil.sign(user);
            map.put("sccessToke",token);

        return map;
    }




}
