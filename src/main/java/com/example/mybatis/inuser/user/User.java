package com.example.mybatis.inuser.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;

    private String updateUsername;   //未修改前的账号
    private String username;
    private String password;
    private String name;
    private String address;

    private String selectByName;

    private Integer size;
    private Integer begin;

    private String date;
    private String email;

    //img转的base64
    private String baseImg;

    //图片的位置
    private String imgUrl;

}

