package ru.croc.task15;

import java.util.*;

public class Task15 {

    public static void main(String[] args) {

        ArrayList<String> ageGroups = new ArrayList<String>();
        for(String s : args){
            ageGroups.add(s);
        }

        ArrayList<String> personsData = new ArrayList<String>();
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        while(!data.equals("END")){
            personsData.add(data);
            data = sc.nextLine();
        }

        DataProcessing.divideByAge(ageGroups, personsData);

        

        sc.close();
    }
    
}
