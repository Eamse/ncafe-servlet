package com.newlecture.entity;

import java.util.Date;

public class Menu {
    private int id;
    private String korName;
    private String engName;
    private String imgSrc;
    private String description;
    private int price;
    private int categoryId;
    private Date createTime;

    public Menu() {
    }

    public Menu(String korName, String engName, String imgSrc, String description, int price, int categoryId) {
        this(0, korName, engName, imgSrc, description, price, categoryId, null);
    }

    public Menu(int id, String korName, String engName, String imgSrc, String description, int price, int categoryId) {
        this(id, korName, engName, imgSrc, description, price, categoryId, null);
    }

    public Menu(int id, String korName, String engName, String imgSrc, String description, int price, int categoryId,
            Date createTime) {
        this.id = id;
        this.korName = korName;
        this.engName = engName;
        this.imgSrc = imgSrc;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKorName() {
        return korName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Menu [id=" + id + ", korName=" + korName + ", price=" + price + ", categoryId=" + categoryId + "]";
    }
}