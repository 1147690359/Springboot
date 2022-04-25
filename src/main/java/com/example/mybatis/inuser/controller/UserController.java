package com.example.mybatis.inuser.controller;

import com.example.mybatis.inuser.service.UserServiceimp;
import com.example.mybatis.inuser.user.User;
import com.example.mybatis.inuser.user.UserFile;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController {


    @Resource
    private UserServiceimp userServiceimp;



    /*
     * GET-获取用户
     * DELETE-删除用户
     * PUT-修改用户
     * POST-保存用户
     */

    /**
     * 加载数据表中数据
     * 查询 表中的所有信息
     * @return 返回查询到的所有数据
     */
    @GetMapping("/user")
    public List<User> user(){
        return userServiceimp.userBy();
    }


    /**
     * 模糊查询
     * @return 返回一个查询到的集合存放sql中的数据
     */
    @GetMapping("/selectByName")
    public List<User> selectByName(@PathParam("selectByName") User user){
        return userServiceimp.selectByName(user);
    }


    /**
     * 根据id 删除表中的数据
     */
    @DeleteMapping("/userDelete/{id}")
    public Map<String, Object> delete(@PathVariable("id") int id ){
        return userServiceimp.delete(id);
    }


    /**
     * 添加功能
     */
    @RequestMapping("/insertUser")
    public Map<String, Object> insertUser(@RequestBody User user){
        return userServiceimp.insertUser(user);
    }

    /**
     * 修改功能
     *
     */
    @PutMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user){
        return userServiceimp.updateUser(user);
    }

    /**
     * 账号登录
     */
    @PostMapping("/index")
    public Map<String, Object> index(@RequestBody User user, HttpSession session){
        return userServiceimp.index(user,session);
    }


    /**
     * 实现图片上传并保存到项目的静态资源的文件夹下面
     */
    @PostMapping("/upload")
    public ModelAndView UploadPicture(@RequestBody UserFile userFile, RedirectAttributes attributes) throws IOException {
        ModelAndView mv = new ModelAndView();
        //判断用户是否上传了文件
        if(!userFile.getFile().isEmpty()){

            //文件上传的地址
            String path = ResourceUtils.getURL("classpath:").getPath()+"static/upload";
            String realPath = path.replace('/', '\\').substring(1,path.length());
            //用于查看路径是否正确
            System.out.println(realPath);

            //获取文件的名称
            final String fileName = userFile.getFile().getOriginalFilename();

            //限制文件上传的类型
            String contentType = userFile.getFile().getContentType();
            if("image/jpeg".equals(contentType) || "image/jpg".equals(contentType) ){
                File file = new File(realPath,fileName);

                //完成文件的上传
                userFile.getFile().transferTo(file);
                System.out.println("图片上传成功!");
                String path01 = "../upload/"+fileName;
                mv.addObject("path" ,path01);
                mv.setViewName("lookphoto");
                return mv;
            } else {
                System.out.println("上传失败！");
                mv.setViewName("upload");
                return mv;
            }
        } else {
            System.out.println("上传失败！");
            mv.setViewName("upload");
            return mv;
        }
    }




}