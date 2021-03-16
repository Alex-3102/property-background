package com.example.demo.controller;

import com.example.demo.entity.Bill;
import com.example.demo.service.PaymentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @ApiOperation(value = "根据用户id获取缴费信息 type : 1为天然气，2为物业，3为水费，4为宽带费，5为电费")
    @GetMapping("/payment/{id}")
    public List<Bill> queryBill(@PathVariable Integer id){
        return paymentService.queryBillsByUserID(id);
    }
}
