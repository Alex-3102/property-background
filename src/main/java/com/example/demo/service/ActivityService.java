package com.example.demo.service;

import com.example.demo.dao.IActivityDao;
import com.example.demo.entity.Activity;
import com.example.demo.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    @Autowired
    private IActivityDao activityDao;

    public List<Activity> getList(int type){
        List<Activity> list = activityDao.getList(type);
        for(Activity activity : list){
            activity.setImage(Util.getImage(activity.getImagePath()));
        }
        return list;
    }

    public boolean add(int type, Activity activity){
        return activityDao.insert(type, activity);
    }
}
