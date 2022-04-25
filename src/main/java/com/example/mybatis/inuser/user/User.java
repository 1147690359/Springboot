package com.example.mybatis.inuser.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String address;

    private String selectByName;

    private Integer size;
    private Integer begin;

    private String date;
    private String email;
    private String baseImg;
}
