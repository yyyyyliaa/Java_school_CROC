package ru.croc.task19;

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

    public Order createOrder(User user, List<Product> products, String deliviryTime, Courier courier){
        Order order = new Order(user.getId(), products, deliviryTime, courier);
        ProductsDao prDao = new ProductsDao(dbPath, username, password);
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)){ 
            for(Product p : products){
                try{
                    p = prDao.createProduct(p);
                }catch(ProductException e){
                    e.getExc();
                }
                PreparedStatement prSt = connection.prepareStatement("INSERT INTO `ORDERS`(USER_ID, USERNAME, PRODUCT_ART, DELIVIRY_TIME, COURIER_ID)" +
                                                                    "VALUES(?,?,?,?,?);");
                prSt.setInt(1, user.getId());
                prSt.setString(2, user.getUsername());
                prSt.setString(3, p.getArt());
                prSt.setString(4, deliviryTime);
                prSt.setInt(5, courier.getId());
                prSt.execute();
            }
            return order;
        }catch (SQLException e){
            e.printStackTrace();
            return order;
        }
    }
    
}
