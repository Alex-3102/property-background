package com.example.demo.service;

import com.example.demo.dao.INoticeDao;
import com.example.demo.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private INoticeDao noticeDao;

    public List<Notice> getNoticeList(int id){
        return noticeDao.getListById(id);
    }
}
