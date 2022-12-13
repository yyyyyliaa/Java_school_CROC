package ru.croc.task19;

import java.sql.*;

public abstract class DBHandler {

    public static void createTabels(String dbPath, String username, String password){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();

            statement.execute("CREATE TABLE IF NOT EXISTS PRODUCTS(ART VARCHAR PRIMARY KEY, NAME VARCHAR, PRICE INTEGER);");
            statement.execute("CREATE TABLE IF NOT EXISTS ORDERS(NUM INTEGER AUTO_INCREMENT, USER_ID INTEGER, USERNAME VARCHAR, " +
             "PRODUCT_ART VARCHAR, DELIVIRY_TIME VARCHAR, COURIER_ID INTEGER);");
            statement.execute("CREATE TABLE IF NOT EXISTS COURIERS(ID INTEGER PRIMARY KEY, NAME VARCHAR, SURNAME VARCHAR);");
            statement.execute("CREATE TABLE IF NOT EXISTS USERS(ID INTEGER PRIMARY KEY, USERNAME VARCHAR);");

        } catch (SQLException e){
            e.printStackTrace();
        }   
    }

    public static void showDB(String dbPath, String username, String password){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();


            System.out.println("ORDERS:");
            ResultSet ordersData = statement.executeQuery("SELECT * FROM `ORDERS`;");
            System.out.println("num\tuser\tart\tdeliviry time\tcourier id");
            while(ordersData.next()){
                System.out.println(ordersData.getInt(1) + "\t" + ordersData.getString(2) + "\t" +
                                    ordersData.getString(3) + "\t" + ordersData.getString(4) +
                                     "\t" + ordersData.getString(5));
            }

            System.out.println("PRODUCTS:");
            ResultSet productsData = statement.executeQuery("SELECT * FROM `PRODUCTS`");
            System.out.println("art\tname\tprice\t");
            while(productsData.next()){
                System.out.println(productsData.getString(1) + "\t" + productsData.getString(2) +
                                    "\t" + productsData.getInt(3));
            }

            System.out.println("COURIERS:");
            ResultSet couriersData = statement.executeQuery("SELECT * FROM `COURIERS`");
            System.out.println("id\tname\tsurname");
            while(couriersData.next()){
                System.out.println(couriersData.getInt(1) + "\t" + couriersData.getString(2) +
                 "\t" + couriersData.getString(3));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }   
    }
}
