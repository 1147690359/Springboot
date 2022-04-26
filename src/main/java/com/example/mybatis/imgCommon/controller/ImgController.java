package com.example.mybatis.imgCommon.controller;


import com.example.mybatis.imgCommon.service.ImgService;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import java.util.Map;

@CrossOrigin
@RestController
public class ImgController {


    @Resource
    private ImgService imgService;





    /**
     * 实现图片上传并保存到项目的静态资源的文件夹下面
     */
    @PostMapping("/upload")
    public  Map<String,Object> UploadPicture(MultipartFile file) throws IOException {

        return imgService.UploadPicture(file);

    }




}