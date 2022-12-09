package ru.croc.task15;

import java.util.*;

public class AgeGroup {
    int maxAge;
    int minAge;

    Set<Person> persons = new HashSet<>();

    public AgeGroup(int minAge, int maxAge){
        this.maxAge = maxAge;
        this.minAge = minAge;
    }

    public int getMaxAge(){
        return maxAge;
    }

    public int getMinAge(){
        return minAge;
    }

    public void addPerson(Person p){
        persons.add(p);
    }

    public boolean groupIsEmpty(){
        return persons.isEmpty();
    }

    @Override
    public String toString(){
        String result = minAge + "-" + maxAge + ":";
        for(Person p : persons){
            result+= p.getFIO() + "(" + p.getAge() + "),";
        }
        return result;
    }
}
