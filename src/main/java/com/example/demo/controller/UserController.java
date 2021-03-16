package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Base64;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "根据username和password和role返回是否允许登录")
    @PostMapping("/login")
    public Boolean islogin(@RequestBody User user){
        return userService.query(user);
    }

    @ApiOperation(value = "根据username获得信息")
    @PostMapping("/getUserInfo/{username}")
    public Map getInfo(@PathVariable("username") String username){
        return userService.getInfo(username);
    }

    @ApiOperation(value = "注册 返回1为成功,0为失败")
    @PostMapping("/register")
    public Integer register(@RequestBody User user){
        return userService.insert(user);
    }

    @ApiOperation(value = "修改头像图片")
    @PostMapping("/user/image/{id}/{imageName}")
    public Boolean updateImage(@PathVariable int id, @PathVariable String imageName, @RequestBody JSONObject data){
        String temp = data.getString("content");
        String imageData = temp.split(";")[1].split(",")[1];
        String filePath = new String("D:/Desktop/a/web/photo/");
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        String imagePath = null;
        try {
            byte[] bytes = Base64.getDecoder().decode(imageData);
            imagePath = filePath + System.currentTimeMillis() + imageName;
            File file = new File(imagePath);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bytes);
            bos.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(imagePath != null){
            return userService.changeImage(id, imagePath);
        }
        return false;
    }
}
