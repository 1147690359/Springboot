package com.example.mybatis.home.service;


import com.example.mybatis.home.mapper.HomeNumMapper;
import com.example.mybatis.home.user.NumUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Service
public class HomeService {

    @Autowired
    private HomeNumMapper homeNumMapper;

    public void Num(){




        String timeMM = "YYYY-MM";
        // DateTimeFormatter.ofPattern方法根据指定的格式输出时间
        String timeDateMM = LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeMM));
        System.out.println(timeDateMM);
        //获取数据库中的时间（根据timeDateMM查询）
        NumUser numUser = homeNumMapper.date(timeDateMM);

        NumUser numUser1= new NumUser();
        System.out.println(numUser);
        if(numUser == null){
            numUser1.setDate(timeDateMM);
            numUser1.setNumber(1);
            homeNumMapper.insert(numUser1);
        }else {
            int a = (numUser.getNumber())+1;
            System.out.println(a);
            numUser.setNumber(a);
            homeNumMapper.update(numUser);
        }

    }
}
