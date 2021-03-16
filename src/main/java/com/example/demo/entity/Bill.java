package com.example.demo.entity;

import io.swagger.annotations.ApiParam;

import java.util.Date;

public class Bill {
    private int id;
    private int user_id;
    private Date date;
    private int price;
    @ApiParam(value = "1为天然气，2为物业，3为水费，4为宽带费，5为电费")
    private int type;

    public Bill() {
    }

    public Bill(int id, int user_id, Date date, int price, int type) {
        this.id = id;
        this.user_id = user_id;
        this.date = date;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
