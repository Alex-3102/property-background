package com.example.demo.dao;

import com.example.demo.entity.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IActivityDao {

    public List<Activity> getList(int type);

    public boolean insert(@Param("type") int type, Activity activity);
}
