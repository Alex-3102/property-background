package com.example.demo.service;

import com.example.demo.dao.IUserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    public UserService() {
    }

    public int insert(User user){
        user.setImagePath(null);
        if(userDao.insert(user) == 0){
            return 0;
        }
        return 1;
    }

    public boolean delete(int id){
        return userDao.delete(id);
    }

    public boolean update(User user){
        return userDao.update(user);
    }

    public User query(int id){
        return userDao.query(id);
    }

    public Boolean query(User user){
        String username = user.getUsername();
        String password = user.getPassword();
        User queryUser = userDao.queryByUsername(username);
        if(queryUser != null && queryUser.getPassword().equals(password) && queryUser.getRole() == user.getRole()){
            return true;
        }
        return false;
    }

    public Map getInfo(String username){
        System.out.println(username);
        User queryUser = userDao.queryByUsername(username);
        HashMap<String, Object> map = null;
        System.out.println(queryUser);
        if(queryUser != null){
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(queryUser.getImagePath());
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] b = new byte[1024];
                int len = -1;
                while((len = fileInputStream.read(b)) != -1) {
                    bos.write(b, 0, len);
                }
                byte[] fileByte = bos.toByteArray();
                BASE64Encoder encoder = new BASE64Encoder();
                String image = encoder.encode(fileByte);
                queryUser.setPassword("");
                map = new HashMap<>(2);
                map.put("user", queryUser);
                map.put("image", image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public boolean changeImage(int id, String imagePath){
        System.out.println(id);
        System.out.println(imagePath);
        return userDao.changeImage(id, imagePath);
    }
}
