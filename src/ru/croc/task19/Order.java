package ru.croc.task19;

import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private String username;
    private List<Product> products;
    private LocalDateTime deliviryTime;
    private Courier courier;

    public Order(String username, List<Product> products, String deliviryTime, Courier courier){
        this.username = username;
        this.products = products;
        this.courier = courier;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMM d, yyyy HH:mm:ss a");
        this.deliviryTime = LocalDateTime.parse(deliviryTime, formatter);
    }

    public String getUsername(){
        return this.username;
    }

    public List<Product> getArt(){
        return this.products;
    }

    public LocalDateTime getDeliviryTime(){
        return deliviryTime;
    }

    public Courier getCourier(){
        return this.courier;
    }
    
}
