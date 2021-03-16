package com.example.demo.controller;

import com.example.demo.entity.Announcement;
import com.example.demo.service.AnnouncementService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnnouncementController {

    @Autowired
    private AnnouncementService announcementService;

    @ApiOperation(value = "获取公告列表")
    @GetMapping("/announcement")
    public List<Announcement> getList(){
        return announcementService.getList();
    }

    @ApiOperation(value = "添加公告数据")
    @PostMapping("/announcement")
    public boolean add(@RequestBody Announcement announcement){
        return announcementService.insert(announcement);
    }
}
