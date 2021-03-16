package com.example.demo.util;

import com.example.demo.entity.Activity;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Util {

    public static String getImage(String path){
        FileInputStream fileInputStream = null;
        String data = null;
        try {
            fileInputStream = new FileInputStream(path);
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
            data = encoder.encode(fileByte);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
