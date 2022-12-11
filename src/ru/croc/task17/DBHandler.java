package ru.croc.task17;

import java.util.*;
import java.sql.*;

public abstract class DBHandler {

    public static void createTablesAndInsertData(String dbPath, String username, String password, List<String> data){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS PRODUCTS(ART VARCHAR PRIMARY KEY, NAME VARCHAR, PRICE INTEGER);");
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS(NUM INTEGER, USERNAME VARCHAR, " +
             "PRODUCT_ART VARCHAR);");

            for(String d : data){
                String[] curOrder = d.split(",");

               PreparedStatement orSt = connection.prepareStatement("INSERT INTO `ORDERS`(NUM,USERNAME,PRODUCT_ART) " + 
                                                                        "VALUES(?,?,?);");
                orSt.setInt(1, Integer.parseInt(curOrder[0]));
                orSt.setString(2, curOrder[1]);
                orSt.setString(3, curOrder[2]);
                orSt.executeUpdate();
                
                PreparedStatement pr1 = connection.prepareStatement("SELECT 1 FROM `PRODUCTS` WHERE " +
                "`ART` = ?");
                pr1.setString(1, curOrder[2]);
                ResultSet rs = pr1.executeQuery();
                if(!rs.next()){
                    PreparedStatement prSt = connection.prepareStatement("INSERT INTO `PRODUCTS`(ART, NAME, PRICE) " +
                    "VALUES(?,?,?);");
                    prSt.setString(1, curOrder[2]);
                    prSt.setString(2, curOrder[3]);
                    prSt.setInt(3, Integer.parseInt(curOrder[4]));
                    prSt.executeUpdate();
                }
                
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
