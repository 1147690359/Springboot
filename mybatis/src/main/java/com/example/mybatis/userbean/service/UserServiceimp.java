package com.example.mybatis.userbean.service;


import com.example.mybatis.userbean.mapper.UserMapper;
import com.example.mybatis.userbean.user.Userbean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceimp  {


    @Autowired
    private UserMapper userMapper;

    /**
     *  1.userb 获取 userMapper.insert（）方法中的返回的值或对象
     *  2.判断是否为空 如果为空 给map 赋值 map.put("index","null") 并返回给前端
     *  3.如果为不为空空 给map 赋值 map.put("index", "in"); 并返回给前端
     * @param userbean
     * @return map 如果查询出的结果为空 map.put("index","null");  不为空map.put("index", "in");
     */
        public Map user(Userbean userbean) {

        Userbean userb= userMapper.selectByuser(userbean);

           Map map=new HashMap();
           if(userb==null){
               map.put("index","null");
           }else {
                map.put("index", "in");
            }
           return map;
    }

    /**
     * 查询表中的所有信息
     * @return list 查询出来的所有信息
     */
    public List userBy(){
            List list=userMapper.select();
            return list;
    }

    /**
     * 根据id删除表格中的数据
     * @param
     * @return del 返回影响的行数
     */
    public int delete(Userbean userbean){
        int del=userMapper.delete(userbean);
        return del;
    }



}
