package ru.croc.task18;

import java.util.*;

public class Task18 {
    public static void main(String[] args) {

        DBHandler.createTables("jdbc:h2:./test", "sa", "1");

        ProductsDao prDao = new ProductsDao("jdbc:h2:./test", "sa", "1");
        OrderDao orderDao = new OrderDao("jdbc:h2:./test", "sa", "1");

        String user = "user1";
        List<Product> products = new ArrayList<>();
        products.add(new Product("T1", "aaa", 100));
        products.add(new Product("T2", "bbb", 200));
        products.add(new Product("T3", "ccc", 400));

        Order order = orderDao.createOrder(user, products);
        System.out.println("-----------------------------------------------------------------");
        DBHandler.showDB("jdbc:h2:./test", "sa", "1");


        Product p = new Product("T2", "ddd", 10000);
        try{
            Product product = prDao.updateProduct(p);
        }catch(ProductException e){
            e.getExc();
        }
        System.out.println("-----------------------------------------------------------------");
        DBHandler.showDB("jdbc:h2:./test", "sa", "1");

        prDao.deleteProduct("T1");
        System.out.println("-----------------------------------------------------------------");
        DBHandler.showDB("jdbc:h2:./test", "sa", "1");

    }
    
}
