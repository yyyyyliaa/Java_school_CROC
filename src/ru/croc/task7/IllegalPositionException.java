package ru.croc.task7;

public class IllegalPositionException extends Exception{
    public IllegalPositionException(String e){
        super(e);
    }
    String getExc(){
        return super.getMessage();
    }
    
}
