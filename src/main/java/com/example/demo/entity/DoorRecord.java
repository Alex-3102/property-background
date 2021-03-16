package com.example.demo.entity;

import java.util.Date;

public class DoorRecord {
    private Date date;
    private String name;
    private String sex;
    private String num;
    private String idCard;

    public DoorRecord() {
    }

    public DoorRecord(Date date, String name, String sex, String num, String idCard) {
        this.date = date;
        this.name = name;
        this.sex = sex;
        this.num = num;
        this.idCard = idCard;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
