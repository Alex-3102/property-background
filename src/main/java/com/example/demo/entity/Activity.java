package com.example.demo.entity;


public class Activity {

    private int id;
    private String title;
    private String address;
    private String location;
    private String businessHours;
    private String peopleNumber;
    private String attention;
    private String image;
    private String imagePath;

    public Activity() {
    }

    public Activity(int id, String title, String address, String location, String businessHours, String peopleNumber, String attention, String image, String imagePath) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.location = location;
        this.businessHours = businessHours;
        this.peopleNumber = peopleNumber;
        this.attention = attention;
        this.image = image;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours;
    }

    public String getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(String peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
