package com.yuh.controller;

import com.yuh.entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author yuhao
 * @date 2022/03/31 16:34
 */
@RestController
@RequestMapping("/test")
public class DemoController {

    /**
     * 返回用户输入的字符串
     * @author yuhao
     * @date 2022/3/31 16:49
     * @param name 用户输入的字符串
     * @return java.lang.String  返回 “Hello”和用户输入的字符串的拼接
     */
    @GetMapping(value = "/api/{name}")
    public String getString(@PathVariable("name") String name){
        return String.format("Hello %s",name);
    }

    /**
     * 返回用户传递的employee对象数据
     * @author yuhao
     * @date 2022/3/31 16:50
     * @param employee 用户传递的employee对象
     * @return com.yuh.entity.Employee
     */
    @PostMapping(value = "/api/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employee;
    }

    /**
     * 返回一个长度为10的随机数数组
     * @author yuhao
     * @date 2022/3/31 16:51 
     * @return int[]
     */
    @RequestMapping("/api/array")
    public int[] getArray(){
        Random random =new Random();
        int [] scores=new int[10];
        for (int i = 0; i < scores.length; i++) {
            scores[i]=random.nextInt(100);
        }
        return scores;
    }

}
