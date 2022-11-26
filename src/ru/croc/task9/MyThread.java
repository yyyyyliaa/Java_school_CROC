package ru.croc.task9;

public class MyThread implements Runnable{

    private long start;
    private long end;
    private String patternHash;

    private static  int flag = 0;

    public MyThread(long start, long end, String patternHash){
        this.start = start;
        this.end = end;
        this.patternHash = patternHash;
    }

    public void run(){
        for(long i = start; i < end; i++){
            if (flag == 1) return;
            else{
                String password = Password.newPasswordCombination(i);
                String hashPassword = Hash.hashPassword(password);
                if(hashPassword.equals(patternHash)){
                    System.out.println("Your password:" + password);
                    flag = 1;
                }
            }
        }
    }


    
}
