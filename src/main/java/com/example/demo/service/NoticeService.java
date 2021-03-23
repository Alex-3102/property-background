package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.dao.INoticeDao;
import com.example.demo.entity.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {
    private final static String CACHE_NAME = new String("NoticeCache::");
    @Autowired
    private INoticeDao noticeDao;

    @Autowired
    RedisServiceImpl redisService;
    public List<Notice> getNoticeList(int id){
//        System.out.println(redisService.get(CACHE_NAME + id));
        List<Notice> notices = JSONObject.parseArray(redisService.get(CACHE_NAME + id), Notice.class);
//        System.out.println(notices);
        if(notices == null){
            notices = noticeDao.getListById(id);
            redisService.set(CACHE_NAME + id, notices);
        }
        return notices;
    }
}
