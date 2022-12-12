package ru.croc.task19;

public class ProductException extends Exception{
    public ProductException(String e){
        super(e);
    }

    public String getExc(){
        return super.getMessage();
    }
}