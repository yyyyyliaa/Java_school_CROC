package ru.croc.task18;

import java.util.*;

public class Order {
    // private Integer num;
    private String username;
    private List<Product> products;

    public Order(String username, List<Product> products){
        // this.num = num;
        this.username = username;
        this.products = products;
    }

    // public Integer getNum(){
    //     return this.num;
    // }

    public String getUsername(){
        return this.username;
    }

    public List<Product> getArt(){
        return this.products;
    }
    
}
