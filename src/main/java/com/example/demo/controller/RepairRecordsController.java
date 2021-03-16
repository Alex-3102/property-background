package com.example.demo.controller;

import com.example.demo.entity.RepairRecord;
import com.example.demo.service.RepairRecordService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepairRecordsController {
    @Autowired
    private RepairRecordService repairRecordService;

    @ApiOperation(value = "根据id获取报修记录")
    @GetMapping("/repair/{id}")
    public RepairRecord getOne(@PathVariable("id") int id){
        return repairRecordService.getRepairRecordById(id);
    }

    @ApiOperation(value = "根据userID获取报修记录列表") // 接口文档显示内容
    @GetMapping("/repairs/{id}")
    public List<RepairRecord> getList(@PathVariable int id) {
        return repairRecordService.getRepairRecordList(id);
    }

    @ApiOperation(value = "新增报修记录") // 接口文档显示内容
    @PostMapping("/repair/{id}")
    public boolean add(@PathVariable int id, @RequestBody RepairRecord record) {
        return repairRecordService.addRepairRecord(id, record);
    }

    @ApiOperation(value = "根据id修改报修记录") // 接口文档显示内容
    @PutMapping("/repair/{id}")
    public boolean update(@PathVariable("id") int id, @RequestBody RepairRecord record) {
        // 修改指定id的学生信息
        record.setId(id);
        return repairRecordService.updateRepairRecord(record);
    }

    @ApiOperation(value = "根据id删除报修记录") // 接口文档显示内容
    @DeleteMapping("/repairs/{id}")
    public boolean delete(@PathVariable("id") int id) {
        return repairRecordService.deleteRepairRecord(id);
    }
}
