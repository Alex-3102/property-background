package com.example.demo.controller;

import com.example.demo.entity.Notice;
import com.example.demo.service.NoticeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticeController {
    @Autowired
    private NoticeService noticeService;

    @ApiOperation(value = "通过user_id获取通知")
    @GetMapping("/notice/{id}")
    public List<Notice> getNoticesById(@PathVariable int id){
        return noticeService.getNoticeList(id);
    }
}
