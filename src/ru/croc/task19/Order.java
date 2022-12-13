package ru.croc.task19;

import java.util.*;

public class Order {
    private Integer userId;
    private List<Product> products;
    private String deliviryTime;
    private Courier courier;

    public Order(Integer userId, List<Product> products, String deliviryTime, Courier courier){
        this.userId = userId;
        this.products = products;
        this.courier = courier;
        this.deliviryTime = deliviryTime;
    }

    public Integer getUserId(){
        return this.userId;
    }

    public List<Product> getArt(){
        return this.products;
    }

    public String getDeliviryTime(){
        return deliviryTime;
    }

    public Courier getCourier(){
        return this.courier;
    }
}
