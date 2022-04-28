package com.example.mybatis.inuser.mapper;


import com.example.mybatis.inuser.user.User;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

     /*
      * mybatis面向接口编程的两个一致
      *1.映射文件 namespace要和mapper接口的全类名保持一致
      * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
      */


     /**
      * 查询表中的所有信息
      * @return List集合存放返回的所有信息
      */
     List<User> select();

     List<User> seleByName(User user);

     int delete(int id);

     int insertUser(User user);

     int updateUser(User user);

     List<User> index(User user);

     String imgUrl(User user);

     String password(String username);

     List<User> selectName(String username);
}
