package ru.croc.task10;

public class User implements Runnable{
    public String name;
    private Lot l;
    public int rate;

    public User(String name, Lot l, int rate){
        this.name = name;
        this.l = l;
        this.rate = rate;
    }

    public void run(){
        l.rates(rate, name);

    }
}
