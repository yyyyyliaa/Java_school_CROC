package ru.croc.task18;

import java.util.*;

import java.sql.*;

public abstract class DBHandler {

    public static void insertData(String dbPath, String username, String password, List<String> data){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS PRODUCTS(ART VARCHAR PRIMARY KEY, NAME VARCHAR, PRICE INTEGER);");
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS(NUM INTEGER PRIMARY KEY AUTO_INCREMENT, USERNAME VARCHAR, " +
             "PRODUCT_ART VARCHAR);");

            for(String d : data){
                String[] curOrder = d.split(",");
                List<Product> products = new ArrayList<>();

                ProductsDao prDao = new ProductsDao(dbPath, username, password);

                try{
                    for (Product p : products){
                        Product tmp = prDao.createProduct(p);
                    }
                }catch(ProductException e){
                    e.getExc();
                }
                

                // PreparedStatement pr = connection.prepareStatement("SELECT 1 FROM `ORDERS` WHERE "+
                // "`NUM` = ?");
                // pr.setInt(1, Integer.parseInt(curOrder[0]));
                // ResultSet res = pr.executeQuery();
                // if(!res.next()){
                    
                    Order order = new Order(Integer.parseInt(curOrder[0]), curOrder[1], products);
                    // PreparedStatement orSt = connection.prepareStatement("INSERT INTO `ORDERS`(NUM,USERNAME,PRODUCT_ART) " + 
                    //                                                     "VALUES(?,?,?);");
                    // orSt.setInt(1, Integer.parseInt(curOrder[0]));
                    // orSt.setString(2, curOrder[1]);
                    // orSt.setString(3, curOrder[2]);
                    // orSt.executeUpdate();
                    //}
                
                
                
            }

        } catch (SQLException e){
            e.printStackTrace();
        }   
    }

    public static void showDB(String dbPath, String username, String password){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();


            System.out.println("ORDERS:");
            ResultSet ordersData = statement.executeQuery("SELECT * FROM `ORDERS`;");
            System.out.println("num\tuser\tart\t");
            while(ordersData.next()){
                System.out.println(ordersData.getInt(1) + "\t" + ordersData.getString(2) + "\t" +
                                    ordersData.getString(3));
            }

            System.out.println("PRODUCTS:");
            ResultSet productsData = statement.executeQuery("SELECT * FROM `PRODUCTS`");
            System.out.println("art\tname\t\tprice\t");
            while(productsData.next()){
                System.out.println(productsData.getString(1) + "\t" + productsData.getString(2) +
                                    "\t\t" + productsData.getInt(3));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }   
    }
}
