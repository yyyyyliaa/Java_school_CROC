package ru.croc.task18;

import java.util.*;

public class OrderDao {

    public Order createOrder(String userLogin, List<Product> products){
        Order order = new Order(1, userLogin, products);
        return order;
    }
    
}
