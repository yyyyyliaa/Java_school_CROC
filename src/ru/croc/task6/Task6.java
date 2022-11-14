//В текстах программ на Java могут использоваться многострочные (/* ... */) и однострочные (// ...) комментарии. 
//Реализовать метод, принимающий на вход строковую переменную - исходный текст программы на Java, 
//вырезающий из этой строки все комментарии и возвращающий результат в виде строки.
 
package ru.croc.task6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task6{

    public static String removeJavaComments(String source){  
        StringBuilder res = new StringBuilder(source);   
                                
        int start = res.toString().indexOf("/*");
        
        while(start!=-1){
            int end = res.toString().indexOf("*/", start)+1; 
            if(end!=-1){
                res.replace(start, end+1, "");
            }
            start = res.toString().indexOf("/*");
        }
        start = res.toString().indexOf("//");
        while(start!=-1){
            int end = res.toString().indexOf("\n", start);
            if(end!=-1){
                res.replace(start, end, "");
            }
            start = res.toString().indexOf("//");
        }
        return res.toString();
    }

    public static String readUsingFiles(String sourceFilePath) throws IOException {
            return new String(Files.readAllBytes(Paths.get(sourceFilePath)));
    }

    public static void main(String[] args) {
        String sourceFilePath = "/Users/yyyyyliaa/CROC/src/ru/croc/task6/Test.java";
        String source = "";
        try{
            source = readUsingFiles(sourceFilePath);
        } catch(IOException e){
            System.out.println("The file does not exist or an error occurred while opening the file");
        }
        
        String result = removeJavaComments(source);
        System.out.println(result);
    }

}