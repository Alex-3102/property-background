package com.example.demo.service;

import com.example.demo.dao.IPaymentDao;
import com.example.demo.entity.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private IPaymentDao paymentDao;

    public List<Bill> queryBillsByUserID(int id){
        return paymentDao.queryBills(id);
    }
}
