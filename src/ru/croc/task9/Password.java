package ru.croc.task9;

public class Password {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    
    public static int passwordLength = 7;

    public static String newPasswordCombination(long combination){
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<passwordLength; i++){
            res.insert(i, alphabet.charAt((int)combination%alphabet.length()));
            combination/=alphabet.length();
        }
        return res.toString();
    }
}