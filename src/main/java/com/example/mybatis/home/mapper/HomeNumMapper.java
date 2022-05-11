package com.example.mybatis.home.mapper;


import com.example.mybatis.home.user.NumUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeNumMapper {


    /**
     * 根据获取的当前时间查询数据库中的数据
     * @param date
     * @return
     */
    NumUser date(String date);

    /**
     * 向数据库中添加 数量 和 时间
     */
    int insert (NumUser numUser);

    /**
     * 修改数据库中的数量
     */
    int update(NumUser numUser);

    List<NumUser> select();
}
