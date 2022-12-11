package ru.croc.task18;

public class ProductException extends Exception{
    public ProductException(String e){
        super(e);
    }

    public String getExc(){
        return super.getMessage();
    }
}