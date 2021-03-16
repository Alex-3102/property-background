package com.example.demo.controller;

import com.example.demo.entity.Activity;
import com.example.demo.service.ActivityService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/activity")
    public Activity getOne(){
        FileInputStream fileInputStream = null;
        Activity activity = null;
        try {
            fileInputStream = new FileInputStream("D:/Desktop/1.jpg");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while((len = fileInputStream.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            byte[] fileByte = bos.toByteArray();
            //以上为读取图片变成字节数组
            //进行base64位加密
            BASE64Encoder encoder = new BASE64Encoder();
            String data = encoder.encode(fileByte);
            System.out.println(data);
//            activity = new Activity();
//            activity.setId(1);
//            activity.setImage(data);
//            activity.setTitle("1111");
//            activity.setPath("D:/Desktop");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return activity;
    }

    @ApiOperation(value = "获取文化活动列表,type=1文化，2体育")
    @GetMapping("/activities/{type}")
    public List<Activity> getList(@PathVariable int type){
        return activityService.getList(type);
    }

    @ApiOperation(value = "获取文化活动列表,type=1文化，2体育")
    @PostMapping("/activities/{type}")
    public Boolean insert(@PathVariable int type, @RequestBody Activity activity){
        return activityService.add(type, activity);
    }

}
