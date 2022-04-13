package com.example.mybatis.userbean.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Data  //get /set 方法
 * @AllArgsConstructor //有参构造器
 * @NoArgsConstructor  //无产构造器
 * @ToString           //toString方法
 * @EqualsAndHashCode //重写EqualsAndHashCode方法
 */
@Data  //get /set 方法
@AllArgsConstructor //有参构造器
@NoArgsConstructor  //无产构造器
@ToString           //toString方法
public class Userbean {
    private int id;
    private String username;
    private String password;
}
