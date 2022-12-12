package ru.croc.task19;

import java.sql.*;

public class CourierDao {
    private String dbPath;
    private String username;
    private String password;

    public CourierDao(String dbPath, String username, String password){
        this.dbPath = dbPath;
        this.username = username;
        this.password = password;
    }

    public void showAllOrders(Courier courier){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            PreparedStatement pr1 = connection.prepareStatement("SELECT * FROM `ORDERS` WHERE " +
                "`COURIER_ID` = ?");
            pr1.setInt(1, courier.getId());
            ResultSet rs = pr1.executeQuery();
            while(!rs.next()){
                final Statement statement = connection.createStatement();
                statement.execute("CREATE TABLE IF NOT EXISTS COURIERS_ORDERS(ID INTEGER PRIMARY KEY, " + 
                "NUM_ORDER INTEGER, RECIPIENT VARCHAR, DELIVIRY_TIME VARCHAR);");
                PreparedStatement prSt = connection.prepareStatement("INSERT INTO `COURIERS_ORDERS`(ID, NUM_ORDER, RECIPIENT, ) " +
                "DELIVIRY_TIME VALUES(?,?,?,?);");
                prSt.setInt(1, courier.getId());
                prSt.setString(2, dbPath);
               
                prSt.executeUpdate();
            } 

        }catch (SQLException e){
            e.printStackTrace();
        }   
    }

}
