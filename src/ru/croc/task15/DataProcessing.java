package ru.croc.task15;

import java.util.*;


public class DataProcessing {
    static void divideByAge(ArrayList<String> ageGroups, ArrayList<String> personsData){

        List<AgeGroup> groups = createAgeGroups(ageGroups);

        for(String s : personsData){
            String[] personInfo = s.split(",");
            Person cur = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            for (AgeGroup group : groups){
                if(cur.getAge()>=group.getMinAge() && cur.getAge()<=group.getMaxAge()){
                    group.addPerson(cur);
                }
            }

        } 

        printGroup(groups);
    }

    public static void printGroup(List<AgeGroup> groups){
        for(AgeGroup group : groups){
            if(!group.groupIsEmpty()) 
                System.out.println(group.toString() + "\n");
        }
    }

    public  static List<AgeGroup> createAgeGroups(ArrayList<String> ageGroups){
        List<AgeGroup> groups = new ArrayList<>();
        AgeGroup cur = new AgeGroup(0, Integer.parseInt(ageGroups.get(0)));
        groups.add(cur);
        for (int i = 1; i<ageGroups.size(); i++){
            cur = new AgeGroup(Integer.parseInt(ageGroups.get(i-1)) + 1, Integer.parseInt(ageGroups.get(i)));
            groups.add(cur);
        }
        cur = new AgeGroup(Integer.parseInt(ageGroups.get(ageGroups.size()-1)) + 1, 123);
        groups.add(cur);
        return groups;
    }
}
