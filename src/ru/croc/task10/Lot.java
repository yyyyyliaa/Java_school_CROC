package ru.croc.task10;

import java.time.LocalTime;

public class Lot {
    private int price = 0;
    private String username;
    public long timeOfStart;
    public long durationTargeting;

    public Lot(int price, long durationTargeting){
        if(price>=0) this.price = price;
        this.durationTargeting = durationTargeting;
        LocalTime now = LocalTime.now();
        this.timeOfStart = now.getSecond();
    }

    synchronized void rates(int price, String username){
        LocalTime now = LocalTime.now();
        long timeOfRates = now.getSecond();
        System.out.println(timeOfRates + " start rate");
        if(timeOfRates>=timeOfStart && timeOfRates<59){
            if(timeOfRates-timeOfStart<=durationTargeting){
                if(price>this.price){
                    this.price = price;
                    this.username = username;
                }
            }
            else{
                System.out.println("End time");
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
