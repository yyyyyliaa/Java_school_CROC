package ru.croc.task19;

import java.util.*;

public class Task19 {
    public static void main(String[] args) {
        DBHandler.createTabels("jdbc:h2:./test", "sa", "1");

        OrderDao orderDao = new OrderDao("jdbc:h2:./test", "sa", "1");
        UserDao usDao = new UserDao("jdbc:h2:./test", "sa", "1");
        CourierDao courDao = new CourierDao("jdbc:h2:./test", "sa", "1");

        
        Courier courier1 = new Courier("name1", "surname1", 1);
        courDao.createCourier(courier1);

        Courier courier2 = new Courier("name2", "surname2", 2);

        User user1 = new User(1, "user1");

        List<Product> products = new ArrayList<>();
        products.add(new Product("T1", "aaa", 100));
        products.add(new Product("T2", "bbb", 200));
        products.add(new Product("T3", "ccc", 400));

        Order order = orderDao.createOrder(user1,products, "30.12.2022", courier1);

        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("T1", "aaa", 100));
        products2.add(new Product("T2", "bbb", 200));
        products2.add(new Product("T3", "ccc", 400));

        Order order2 = orderDao.createOrder(user1, products2, "2.01.2023", courier2);

        usDao.showUserOrders(user1);
        System.out.println("-----------------------------------------------------------------");

        courDao.showCourierOrders(courier1);
        System.out.println("-----------------------------------------------------------------");

        courDao.showCourierOrders(courier2);
    }
}
