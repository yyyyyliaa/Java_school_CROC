package ru.croc.task19;

import java.util.*;

public class Courier {
    private String name;
    private String surname;
    private Integer id;
    private List<Order> orders;

    public Courier(String name, String surname, Integer id, List<Order> orders){
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.orders = orders;
    }

    public String getName(){
        return this.name;
    }

    public String getSuString(){
        return this.surname;
    }

    public Integer getId(){
        return this.id;
    }

    public List<Order> geOrders(){
        return this.orders;
    }


}
