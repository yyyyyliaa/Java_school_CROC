package ru.croc.task7;

public class IllegalMoveException extends Exception{
    public IllegalMoveException(String e){
        super(e);
    }
    String getExc(){
        return super.getMessage();
    }
}
