package com.example.mybatis.userbean.mapper;


import com.example.mybatis.userbean.user.Userbean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

     /**
      * mybatis面向接口编程的两个一致
      *1.映射文件 namespace要和mapper接口的全类名保持一致
      * 2.映射文件中SQL语句的id要和mapper接口中的方法名一致
      */

     /**
      * 根据用户名和密码查询 所有数据
      *
      */
     Userbean selectByuser(Userbean userbean);


     /**
      * 查询表中的所有信息
      * @return
      */
     List<Userbean> selecta();

     /**
      * 根据id删除 对应的行
      * @param
      * @return 影响的行数
      */
     int delete(Userbean userbean);


     /**
      *  t_user中添加username 和 password
      * @param userbean
      * @return 影响的行数
      */
     int insert(Userbean userbean);

     /**
      * 根据id 修改
      * @param userbean
      * @return
      */
     int update(Userbean userbean);

}
