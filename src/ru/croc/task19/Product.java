package ru.croc.task19;

public class Product {
    private String art;
    private String name;
    private Integer price;

    public Product(String art, String name, Integer price){
        this.art = art;
        this.name = name;
        this.price = price;
    }

    public String getArt(){
        return this.art;
    }

    public String getName(){
        return this.name;
    }

    public Integer getPrice(){
        return this.price;
    }
}
