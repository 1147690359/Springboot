package com.example.mybatis.school.user;

import lombok.Data;

import java.util.List;

@Data
public class CourseUser {
    private Integer c_id;
    private String c_name;
    private Integer c_time;
    private Integer c_number;
    private List<StudentUser> studentUsers;
    private TeacherUser teacherUser;
}
