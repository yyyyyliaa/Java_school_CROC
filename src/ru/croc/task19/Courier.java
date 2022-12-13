package ru.croc.task19;


public class Courier {
    private String name;
    private String surname;
    private Integer id;

    public Courier(String name, String surname, Integer id){
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public Integer getId(){
        return this.id;
    }
}
