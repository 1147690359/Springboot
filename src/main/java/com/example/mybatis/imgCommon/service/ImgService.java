package com.example.mybatis.imgCommon.service;



import com.example.mybatis.imgCommon.mapper.ImgMapper;
import com.example.mybatis.inuser.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class ImgService  {


//    @Resource
//    private ImgMapper imgMapper;

    public Map<String,Object> UploadPicture (MultipartFile file)  throws IOException {
        //上传文件的名字
        String fileName = file.getOriginalFilename();

        // 获取文件的后缀名,比如图片的jpeg,png
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        System.out.println("上传的后缀名为：" + suffixName);

        fileName = UUID.randomUUID() + suffixName;

        // 上传文件/图像到指定文件夹（这里可以改成你想存放地址的相对路径）
        File savePos = new File("src/main/resources/static/images");
        if(!savePos.exists()){  // 不存在，则创建该文件夹
            savePos.mkdir();
        }
        // 获取存放位置的规范路径s
        String realPath = savePos.getCanonicalPath();
//        String folder=realPath+"/"+file.getOriginalFilename();
        // 上传该文件/图像至该文件夹下
        file.transferTo(new File(realPath,fileName));

        String imgUrl="http://localhost:1022/static/images/"+fileName;
        System.out.println(imgUrl);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("imgUrl",imgUrl);
        return map;
    }







}
