package com.px.pojo;

//Create a User class
public class User {
    //Declare variables to store user information
    private String name;
    private String email;
    private String password;
    private String consignee;
    private String address;
    private String phone;
    private int vip;

    //Getter methods to return user information
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    //Override the toString method to return user information


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", consignee='" + consignee + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", vip=" + vip +
                '}';
    }
}