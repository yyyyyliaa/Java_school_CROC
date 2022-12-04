package ru.croc.task15;

import java.util.*;

public class DataProcessing {
    static void divideByAge(ArrayList<String> ageGroups, ArrayList<String> personsData){

        List<AgeGroup> groups = createAgeGroups(ageGroups);

        for(String s : personsData){
            String[] personInfo = s.split(",");
            for (AgeGroup group : groups){
                if(Integer.parseInt(personInfo[1])>=group.getMinAge() && Integer.parseInt(personInfo[1])<=group.getMaxAge()){
                    group.addPerson(personInfo[0], Integer.parseInt(personInfo[1]));
                }
            }

        } 

        printGroup(groups);
    }

    public static void printGroup(List<AgeGroup> groups){
        for(AgeGroup group : groups){
            if(!group.getPersons().isEmpty()) 
                System.out.println(group.toString() + "\n");
        }
    }

    public  static List<AgeGroup> createAgeGroups(ArrayList<String> ageGroups){
        List<AgeGroup> groups = new ArrayList<>();
        for (int i = 0; i<ageGroups.size(); i++){
            AgeGroup cur;
            if(i == 0){
                cur = new AgeGroup(0, Integer.parseInt(ageGroups.get(i)));
            }
            else if (i == ageGroups.size()){
                cur = new AgeGroup(Integer.parseInt(ageGroups.get(ageGroups.size()-1)) + 1, 123);
            }
            else{
                cur = new AgeGroup(Integer.parseInt(ageGroups.get(i-1)) + 1, Integer.parseInt(ageGroups.get(i)));
            }
            groups.add(cur);
        }

        return groups;
    }
    
}
