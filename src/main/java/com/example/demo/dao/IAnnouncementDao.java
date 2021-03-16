package com.example.demo.dao;

import com.example.demo.entity.Announcement;

import java.util.List;

public interface IAnnouncementDao {

    public List<Announcement> getAnnouncements();

    public boolean insert(Announcement announcement);
}
