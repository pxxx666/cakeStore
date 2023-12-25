package com.px.pojo;

public class Car {
    // 定义id属性
    private  int id;
    // 定义产品名称属性
    private String productName;
    // 定义产品价格属性
    private double productPrice;
    // 定义产品图片属性
    private String productUrl;
    // 定义用户名属性
    private String userName;

    // 获取id属性
    public int getId() {
        return id;
    }

    // 获取产品图片属性
    public String getProductUrl() {
        return productUrl;
    }

    // 设置产品图片属性
    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    // 设置id属性
    public void setId(int id) {
        this.id = id;
    }

    // 获取产品名称属性
    public String getProductName() {
        return productName;
    }

    // 设置产品名称属性
    public void setProductName(String productName) {
        this.productName = productName;
    }

    // 获取产品价格属性
    public double getProductPrice() {
        return productPrice;
    }

    // 设置产品价格属性
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    // 获取用户名属性
    public String getUserName() {
        return userName;
    }

    // 设置用户名属性
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productUrl='" + productUrl + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}