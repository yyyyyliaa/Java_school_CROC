package ru.croc.task18;

import java.util.*;
import java.sql.*;

public class OrderDao {
    private String dbPath;
    private String username;
    private String password;

    public OrderDao(String dbPath, String username, String password){
        this.dbPath = dbPath;
        this.username = username;
        this.password = password;
    }

    public Order createOrder(String userLogin, List<Product> products){
        Order order = new Order(userLogin, products);
        ProductsDao prDao = new ProductsDao(dbPath, username, password);
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)){ 
            for(Product p : products){
                try{
                    p = prDao.createProduct(p);
                }catch(ProductException e){
                    e.getExc();
                }
                PreparedStatement prSt = connection.prepareStatement("INSERT INTO `ORDERS`(USERNAME, PRODUCT_ART)" +
                                                                    "VALUES(?,?);");
                prSt.setString(1, userLogin);
                prSt.setString(2, p.getArt());
                prSt.execute();
            }
            return order;
        }catch (SQLException e){
            e.printStackTrace();
            return order;
        }
    }

    public void showUserOrders(){
        
    }
    
}
