package com.example.demo.service;

import com.example.demo.dao.IDoorRecordDao;
import com.example.demo.entity.DoorRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoorRecordService {

    @Autowired
    private IDoorRecordDao doorRecordDao;

    public boolean insert(int userId, DoorRecord doorRecord){
        return doorRecordDao.insert(userId, doorRecord);
    }

    public List<DoorRecord> query(int userId){
        return doorRecordDao.queryRecords(userId);
    }
}
