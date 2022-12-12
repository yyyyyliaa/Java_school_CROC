package ru.croc.task18;

import java.sql.*;

public class ProductsDao {
    private String dbPath;
    private String username;
    private String password;

    public ProductsDao(String dbPath, String username, String password){
        this.dbPath = dbPath;
        this.username = username;
        this.password = password;
    }

    public Product createProduct(Product product) throws ProductException{
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            PreparedStatement pr1 = connection.prepareStatement("SELECT 1 FROM `PRODUCTS` WHERE " +
                "`ART` = ?");
            pr1.setString(1, product.getArt());
            ResultSet rs = pr1.executeQuery();
            if(!rs.next()){
                PreparedStatement prSt = connection.prepareStatement("INSERT INTO `PRODUCTS`(ART, NAME, PRICE) " +
                "VALUES(?,?,?);");
                prSt.setString(1, product.getArt());
                prSt.setString(2, product.getName());
                prSt.setInt(3, product.getPrice());
                prSt.executeUpdate();
            } else throw new ProductException("The product is not in the database");

        }catch (SQLException e){
            e.printStackTrace();
        }   
        return product;
    }

    public Product findProduct(String productCode){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            PreparedStatement pr1 = connection.prepareStatement("SELECT 1 FROM `PRODUCTS` WHERE " +
                "`ART` = ?");
            pr1.setString(1, productCode);
            ResultSet rs = pr1.executeQuery();
            if(!rs.next()){
                Product product = new Product(productCode, rs.getString(2), rs.getInt(3));
                return product;
            }
            else return null;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }   
    }

    public Product updateProduct(Product product) throws ProductException{
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            PreparedStatement pr1 = connection.prepareStatement("SELECT 1 FROM `PRODUCTS` WHERE " +
                "`ART` = ?");
            pr1.setString(1, product.getArt());
            ResultSet rs = pr1.executeQuery();
            if(rs.next()){
                PreparedStatement pr2 = connection.prepareStatement("UPDATE `PRODUCTS` SET NAME=? WHERE ART=?");
                pr2.setString(1, product.getName());
                // pr2.setInt(2, product.getPrice());
                pr2.setString(2, product.getArt());
                pr2.execute();


            return product;
            } else throw new ProductException("The product is not in the database");

        }catch (SQLException e){
            e.printStackTrace();
            return product;
        }   
    }

    public void deleteProduct(String productCode){
        try (Connection connection = DriverManager.getConnection(dbPath, username, password)) {
            PreparedStatement pr1 = connection.prepareStatement("DELETE FROM ORDERS WHERE " +
                "`PRODUCT_ART` = ?");
            pr1.setString(1, productCode);
            pr1.execute();

            pr1 = connection.prepareStatement("DELETE FROM PRODUCTS WHERE " +
            "`ART` = ?");
            pr1.setString(1, productCode);
            pr1.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }   
    }
}
