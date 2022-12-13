package ru.croc.task19;

import java.sql.*;;

public class UserDao {
    private String dbPath;
    private String username;
    private String password;

    public UserDao(String dbPath, String username, String password){
        this.dbPath = dbPath;
        this.username = username;
        this.password = password;
    }

    public void showUserOrders(User user){
        System.out.println("User ID = " + user.getId());
        System.out.println("ORDERS:");
        System.out.println("NUM\tDELIVIRY_TIME\tCOURIER_ID\t");
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            final Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS `USER_ORDERS`(NUM INTEGER PRIMARY KEY, " +
            "DELIVIRY_TIME VARCHAR, COURIER_ID INTEGER)");
            PreparedStatement pr1 = connection.prepareStatement("SELECT * FROM `ORDERS` WHERE " +
                "`USER_ID` = ?");
            pr1.setInt(1, user.getId());
            ResultSet rs = pr1.executeQuery();
            while(rs.next()){
                PreparedStatement pr2 = connection.prepareStatement("SELECT * FROM `USER_ORDERS` WHERE " +
                "`DELIVIRY_TIME` = ?");
                pr2.setString(1, rs.getString("DELIVIRY_TIME"));
                ResultSet res = pr2.executeQuery();
                if(!res.next()){
                    PreparedStatement pr3 = connection.prepareStatement("INSERT INTO `USER_ORDERS`(NUM, DELIVIRY_TIME, COURIER_ID) " +
                    "VALUES(?,?,?);");
                    pr3.setInt(1, rs.getInt("NUM"));
                    pr3.setString(2, rs.getString("DELIVIRY_TIME"));
                    pr3.setInt(3, rs.getInt("COURIER_ID"));
                    pr3.execute();
                    System.out.println(rs.getString("NUM") + "\t" + rs.getString("DELIVIRY_TIME") +
                                    "\t" + rs.getInt("COURIER_ID"));
                }
            } 
            statement.execute("DROP TABLE IF EXISTS `USER_ORDERS`");

        }catch (SQLException e){
            e.printStackTrace();
        }   
    }
}
