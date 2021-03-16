package com.example.demo.dao;

import com.example.demo.entity.Notice;

import java.util.List;

public interface INoticeDao {

    public List<Notice> getListById(int userId);

}
