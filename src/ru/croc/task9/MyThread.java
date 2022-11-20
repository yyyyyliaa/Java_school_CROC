package ru.croc.task9;

public class MyThread implements Runnable{
    private int position;
    // private StringBuilder result;
    private String pattern;
    private int limit;
    private int start;

    private Password p = new Password();


    public MyThread(int position, String pattern, int start, int limit){
        this.position = position;
        // this.result = result;
        this.pattern = pattern;
        this.start = start;
        this.limit = limit;
    }

    public void run(){
        p.pickUpPassword(position, pattern, start, limit);
    }
    
}
