package com.example.demo.dao;

import com.example.demo.entity.Bill;

import java.util.List;

public interface IPaymentDao {

    public List<Bill> queryBills(int user_id);

}
