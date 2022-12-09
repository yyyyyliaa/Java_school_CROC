package ru.croc.task15;

public class Person {
    private String FIO;
    private Integer age;

    public Person(String FIO, Integer age){
        this.FIO = FIO;
        this.age = age;
    }

    public String getFIO(){
        return this.FIO;
    }
    
    public Integer getAge(){
        return this.age;
    }
}
