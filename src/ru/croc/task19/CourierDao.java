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

    public void createCourier(Courier courier){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)){ 
            PreparedStatement pr1 = connection.prepareStatement("SELECT ID FROM `COURIERS` WHERE " +
                "`ID` = ?");
            pr1.setInt(1, courier.getId());
            ResultSet rs = pr1.executeQuery();
            if(!rs.next()){
                PreparedStatement prSt = connection.prepareStatement("INSERT INTO `COURIERS`(ID, NAME, SURNAME)" +
                                                                    "VALUES(?,?,?);");
                prSt.setInt(1, courier.getId());
                prSt.setString(2, courier.getName());
                prSt.setString(3, courier.getSurname());
                prSt.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void showCourierOrders(Courier courier){
        System.out.println("Courier ID = " + courier.getId());
        System.out.println("ORDERS:");
        System.out.println("NUM\tUSERNAME\tDELIVIRY_TIME\t");
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `COURIER_ORDERS`(NUM INTEGER PRIMARY KEY, " +
            "USERNAME VARCHAR, DELIVIRY_TIME VARCHAR)");

            PreparedStatement pr1 = connection.prepareStatement("SELECT * FROM `ORDERS` WHERE " +
                "`COURIER_ID` = ?");
            pr1.setInt(1, courier.getId());
            ResultSet rs = pr1.executeQuery();
            while(rs.next()){
                PreparedStatement pr2 = connection.prepareStatement("SELECT * FROM `COURIER_ORDERS` WHERE " +
                "`DELIVIRY_TIME` = ?");
                pr2.setString(1, rs.getString("DELIVIRY_TIME"));
                ResultSet res = pr2.executeQuery();
                if(!res.next()){
                    PreparedStatement pr3 = connection.prepareStatement("INSERT INTO `COURIER_ORDERS`(NUM, USERNAME, DELIVIRY_TIME) " +
                    "VALUES(?,?,?);");
                    pr3.setInt(1, rs.getInt("NUM"));
                    pr3.setString(2, rs.getString("USERNAME"));
                    pr3.setString(3, rs.getString("DELIVIRY_TIME"));
                    pr3.execute();
                    System.out.println(rs.getInt("NUM") + "\t" +
                    rs.getString("USERNAME") + "\t\t" + rs.getString("DELIVIRY_TIME"));
                }
            } 

            statement.execute("DROP TABLE IF EXISTS `COURIER_ORDERS`");


        }catch (SQLException e){
            e.printStackTrace();
        }   
    }

}
