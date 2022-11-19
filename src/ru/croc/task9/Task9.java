/*Напишите программу, которая методом полного перебора напомнит вам пароль. 
Причем за наиболее короткий срок - пароль вам нужен как можно быстрее. 
Для ускорения процесса вы решили перебор выполнять в несколько потоков.
Количество потоков - входные данные для программы, задается первым аргументом командной строки. 
Хеш пароля - вторым аргументом. Найденный пароль печатается в стандартный поток вывода.*/

package ru.croc.task9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Task9 {
    private static String alphabet = "abcdefghigklmnopqrstuvwxyz";
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

    private static String toHexString(byte[] bytes) {
        StringBuilder hex = new StringBuilder(bytes.length * 2);
        for (byte b : bytes) {
            hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
            hex.append(HEX_DIGITS[b & 0x0f]);
        }
        return hex.toString();
    }

    public static String hashPassword(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        digest.update(password.getBytes());
        byte[] bytes = digest.digest();
        return toHexString(bytes);
    }

    public static void pickUpPassword(int position, StringBuilder result, String pattern){
        if (position == 7){
            String testHash = hashPassword(result.toString());
            if(testHash.equals(pattern)){
                System.out.println("Your password:" + result.toString());
            }
        } 
        else{
            for (int i = 0; i<alphabet.length(); i++){
                if(result.length()>position){
                    result.deleteCharAt(position);
                }
                result.insert(position, alphabet.charAt(i)); 
                pickUpPassword(position+1, result, pattern);
            }
        }
    }
    public static void main(String[] args) {
        // int countOfThreads = Integer.parseInt(args[0]);
        // String passwordHash = "40682260CC011947FC2D0B1A927138C5";
        String tHash = hashPassword("aaaaaaa");
       
        StringBuilder result = new StringBuilder();
        pickUpPassword(0, result, tHash);
    }
}
