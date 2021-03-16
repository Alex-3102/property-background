package com.example.demo.dao;

import com.example.demo.entity.DoorRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDoorRecordDao {

    public boolean insert(@Param("userId") int userId, DoorRecord record);

    public List<DoorRecord> queryRecords(int userId);
}
