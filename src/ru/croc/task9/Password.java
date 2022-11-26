package ru.croc.task9;

public class Password implements Runnable{
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    private long start;
    private long end;
    private String patternHash;
    private static volatile int flag = 0;
    public static int passwordLength = 7;

    public Password(long start, long end, String patternHash){
        this.start = start;
        this.end = end;
        this.patternHash = patternHash;
    }

    public String newPasswordCombination(long combination){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<passwordLength; i++){
            res.insert(i, alphabet.charAt((int)combination%alphabet.length()));
            combination/=alphabet.length();
        }
        return res.toString();
    }

    public void run(){
        for(long i = start; i < end; i++){
            if (flag == 1) return;
            else{
                String password = newPasswordCombination(i);
                String hashPassword = Hash.hashPassword(password);
                if(hashPassword.equals(patternHash)){
                    System.out.println("Your password:" + password);
                    flag = 1;
                }
            }
        }
    }
}