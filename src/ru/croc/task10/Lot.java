package ru.croc.task10;

public class Lot {
    private int price = 0;
    private String username;
    private int timeOfEnd;

    public Lot(int price, String username, int timeOfEnd){
        if(price>=0) this.price = price;
        if(!username.equals("")) this.username = username;
        this.timeOfEnd = timeOfEnd;
    }

    public void rates(int price, String username){
        if(price>this.price && timeOfEnd!=0){
            this.price = price;
            this.username = username;
        }
    }

    public String getUsername(){
        return this.username;
    }
}
