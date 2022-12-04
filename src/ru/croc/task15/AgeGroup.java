package ru.croc.task15;

import java.util.*;

public class AgeGroup {
    int maxAge;
    int minAge;

    Map<String, Integer> persons = new HashMap<>();

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

    public Map<String, Integer> getPersons(){
        return persons;
    }

    public void addPerson(String name, Integer age){
        persons.put(name, age);
    }

    @Override
    public String toString(){
        String result = minAge + "-" + maxAge + ":";
        Iterator<Map.Entry<String, Integer>> it = persons.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String, Integer> entry = it.next();
            result += entry.getKey() + "(" + entry.getValue() + "), ";
        }

        return result;
    }
}
