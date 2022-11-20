package ru.croc.task10;

import java.time.LocalDateTime;

public class Lot {
    private int price = 0;
    private String username;
    LocalDateTime endOfRates;


    public Lot(int price, long durationTargeting){
        if(price>=0) this.price = price;
        endOfRates = LocalDateTime.now().plusSeconds(durationTargeting);
    }

    synchronized void rates(int price, String username){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.toString() + " start rate");
        if(now.isBefore(endOfRates)){
            if(price>this.price){
                this.price = price;
                this.username = username;
            }
        }
    }
    

    public String getUsername(){
        return this.username;
    }

    public int getPrice(){
        return this.price;
    }
}
