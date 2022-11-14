//В текстах программ на Java могут использоваться многострочные (/* ... */) и однострочные (// ...) комментарии. 
//Реализовать метод, принимающий на вход строковую переменную - исходный текст программы на Java, 
//вырезающий из этой строки все комментарии и возвращающий результат в виде строки.
 
package ru.croc.task6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Task6{

    public static enum flag{
        NO_COMMENT,
        SINGLE_LINE_COMMENT,
        MULTILINE_COMMENT
    }

    public static String removeJavaComments(String source){  //flag == 0 - не комментарий
        String res = "";                                   //flag == 1 - многострочный комментарий
        flag f = flag.NO_COMMENT;                                        //flag == 2 - однострочный комментарий
        for(int i = 0; i<source.length(); i++){
            if(source.charAt(i) == '/' && source.charAt(i+1)=='*'){
                if (f == flag.NO_COMMENT){
                    f = flag.SINGLE_LINE_COMMENT;
                    i++;
                }
            }
            else if(source.charAt(i) == '*' && source.charAt(i+1)=='/'){
                if(f == flag.SINGLE_LINE_COMMENT){
                    f = flag.NO_COMMENT;
                    i+=2;
                }
            }
            else if(source.charAt(i) == '/' && source.charAt(i+1)=='/'){
                if (f == flag.NO_COMMENT) {
                    f = flag.MULTILINE_COMMENT;
                    i++;
                }
            }
            else if(source.charAt(i) == '\n'){
                if (f == flag.MULTILINE_COMMENT) 
                    f = flag.NO_COMMENT;
            }
            if(f == flag.NO_COMMENT){
                res+=source.charAt(i);
            }
        }
        return res;
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
        
        // System.out.println(source);
        String result = removeJavaComments(source);
        System.out.println(result);
    }

}