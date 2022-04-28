package com.example.mybatis.school.mapper;

import com.example.mybatis.school.user.CourseUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolMapper {

    List<CourseUser> select(CourseUser courseUser);


}
