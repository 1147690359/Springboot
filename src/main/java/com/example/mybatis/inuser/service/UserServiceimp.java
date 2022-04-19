package com.example.mybatis.inuser.service;


import com.example.mybatis.inuser.mapper.UserMapper;

import com.example.mybatis.inuser.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimp  {


    @Autowired
    private UserMapper userMapper;



    /**
     * 查询表中的所有信息
     * @return list 查询出来的所有信息
     */
    public List userBy(){
            List list=userMapper.select();
            return list;
    }


    public List selectByName(User user){
        List<User> list= userMapper.seleByName(user);
        return list;
    }


    public Map delete(int id){
        int in = userMapper.delete(id);
        Map map=new HashMap();
        if (in == 0){
            map.put("del","null");
        }else {
            map.put("del","have");
        }
        return map;
    }


//    public List<User> page(int begin, int size){
//        List<User> list=userMapper.pageSelect(begin,size);
//        return list;
//    }

    public Map insertUser(User user){
        Map map=new HashMap();
        int in = userMapper.insertUser(user);
        if (in == 0){
            map.put("ins","null");
        }else {
            map.put("ins","have");
        }
        return map;
    }

    public Map updateUser(User user){
        Map map=new HashMap();
        int in = userMapper.updateUser(user);
        if (in == 0){
            map.put("update","null");
        }else {
            map.put("update","have");
        }
        return map;
    }


    public Map index(User user, HttpSession session){
        Map map=new HashMap();
        List<User> in = userMapper.index(user);
        if (in.isEmpty()){
            map.put("index","null");
        }else {
            map.put("index","have");
            session.setAttribute("loginUser",user.getUsername());
        }
        return map;
    }




}
