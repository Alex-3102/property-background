package com.example.demo.entity;

import java.util.Date;

public class Announcement {

    private int id;
    private Date date;
    private String title;
    private String ano;

    public Announcement() {
    }

    public Announcement(int id, Date date, String title, String ano) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.ano = ano;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
