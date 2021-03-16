package com.example.demo.service;

import com.example.demo.dao.IRepairRecordDao;
import com.example.demo.entity.RepairRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service // 注册为服务类
public class RepairRecordService {


    @Autowired
    private IRepairRecordDao repairRecordDao;

    public RepairRecordService() {
    }

    public List<RepairRecord> getRepairRecordList(int id) {
        return repairRecordDao.selectAllByID(id);
    }

    public RepairRecord getRepairRecordById(int id) {
        return repairRecordDao.query(id);
    }

    public Boolean addRepairRecord(int id, RepairRecord record){
        return repairRecordDao.insert(id, record);
    }

    public Boolean updateRepairRecord(RepairRecord record){
        return repairRecordDao.update(record);
    }

    public Boolean deleteRepairRecord(int id){
        return repairRecordDao.delete(id);
    }

}
