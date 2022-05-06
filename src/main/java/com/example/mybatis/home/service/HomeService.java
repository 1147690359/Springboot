package com.example.mybatis.home.service;


import com.example.mybatis.home.mapper.HomeNumMapper;
import com.example.mybatis.home.user.NumUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class HomeService {

    @Resource
    private HomeNumMapper homeNumMapper;

    public void Num(){



        String format = "YYYY-MM-dd";
        String timeMM = "YYYY-MM";
        // DateTimeFormatter.ofPattern方法根据指定的格式输出时间
        String formatDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
        String timeDateMM = LocalDateTime.now().format(DateTimeFormatter.ofPattern(timeMM));


    }
}
