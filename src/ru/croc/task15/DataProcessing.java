package ru.croc.task15;

import java.util.*;

public class DataProcessing {
    static void divideByAge(ArrayList<String> ageGroups, ArrayList<String> personsData){
        Map<String, Integer> persons = new HashMap<>();
        for(String s : personsData){
            String[] tmp = s.split(",");
            persons.put(tmp[0], Integer.parseInt(tmp[1]));
        } 
        
        Map<String, Integer> group = new HashMap<>();
        for(int i = 0; i<=ageGroups.size(); i++){
            int maxAge;
            int minAge;

            if(i == 0){
                maxAge = Integer.parseInt(ageGroups.get(i));
                minAge = 0;
            } 
            else if(i == ageGroups.size()){
                maxAge = 123;
                minAge = Integer.parseInt(ageGroups.get(ageGroups.size()-1)) + 1;
            }
            else{
                maxAge = Integer.parseInt(ageGroups.get(i));
                minAge = Integer.parseInt(ageGroups.get(i-1)) + 1;
            }
            Iterator<Map.Entry<String, Integer>> it = persons.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();
                if(entry.getValue()<=maxAge && entry.getValue()>=minAge){
                    group.put(entry.getKey(), entry.getValue());
                }
            }
            if(!group.isEmpty()){
                printGroup(minAge, maxAge, group);
                group.clear();
            }
        }
    }

    public static void printGroup(int minAge, int maxAge, Map<String, Integer> group){
        Iterator<Map.Entry<String, Integer>> it = group.entrySet().iterator();
        System.out.print(minAge + "-" + maxAge + ": ");
            it = group.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String, Integer> entry = it.next();
                System.out.print(entry.getKey() + "(" + entry.getValue() + "), ");           
            }
            System.out.println("\n");
    }
    
}
