package ru.croc.task9;

public class MyThread implements Runnable{
    private int position;
    private String pattern;
    private int limit;
    private int start;

    public StringBuilder result = new StringBuilder();


    public MyThread(int position, String pattern, int start, int limit){
        // this.result = result;
        this.position = position;
        this.pattern = pattern;
        this.start = start;
        this.limit = limit;
    }

    public void run(){
        Password.pickUpPassword(result, position, pattern, start, limit);
    }
    
}
