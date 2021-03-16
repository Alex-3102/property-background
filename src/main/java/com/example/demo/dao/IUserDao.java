package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IUserDao {

    public int insert(User user);

    public boolean delete(int id);

    public boolean update(User user);

    public User query(int id);

    public User queryByUsername(String username);

    public Boolean changeImage(@Param("userId") int userId, @Param("imagePath") String imagePath);
}
