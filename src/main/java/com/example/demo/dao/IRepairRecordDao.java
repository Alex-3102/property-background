package com.example.demo.dao;

import com.example.demo.entity.RepairRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IRepairRecordDao {

    public boolean insert(@Param("userId") int userId, RepairRecord record);

    public boolean delete(int id);

    public boolean update(RepairRecord record);

    public List<RepairRecord>  selectAllByID(int userId);

    public RepairRecord query(int id);

}
