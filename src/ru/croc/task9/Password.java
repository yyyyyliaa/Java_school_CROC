package ru.croc.task9;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Password {

    public static String alphabet = "abcdefghigklmnopqrstuvwxyz";
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

    public static int flag = 0;
    public StringBuilder result = new StringBuilder();

    public static void pickUpPassword(StringBuilder result, int position, String pattern,int start, int limit){
        if (position == 7){
            String testHash = hashPassword(result.toString());
            if(testHash.equals(pattern)){
                System.out.println("Your password:" + result.toString());
                flag = 1;
            }
        } 
        else{
            for (int i = start; i<limit; i++){
                if(result.length()>position){
                    result.deleteCharAt(position);
                }
                result.append(alphabet.charAt(i)); 
                pickUpPassword(result, position+1, pattern, 0, alphabet.length());
                if(flag==1) return;
                
            }
        }
    }
    
}
