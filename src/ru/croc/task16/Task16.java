package ru.croc.task16;

import java.util.*;

public class Task16 {

    public static List<String> types = Arrays.asList("Эконом", "Комфорт", "Комфорт+", "Бизнес");
    public static List<String> peculiarities = Arrays.asList("Детское кресло", "Опытный водитель", "Можно с животными");
    
    public static void main(String[] args) {
    
        // String[] loc = args[0].split(",");
        // double lat = Double.parseDouble(loc[0]);
        // double lon = Double.parseDouble(loc[1]);
        // Location location = new Location(lat, lon);
        // String requestType = args[1];
        // List<String> wishes = Arrays.asList(args[2].split(","));


        double lat = 60.023250;
        double lon = 30.625827;
        Location location = new Location(lat, lon);
        String requestType = "Комфорт";
        List<String> wishes = Arrays.asList("Можно с животными");


        boolean suitableForAllSpecials = true;
        for(String w : wishes){
            if(!peculiarities.contains(w)){
                suitableForAllSpecials = false;
                break;
            }
        }

        if(types.contains(requestType) && suitableForAllSpecials==true){
            Client test = new Client(location, requestType, wishes);
            System.out.println(DriverSelectionModul.SelectDriver(test));
        }
        else{
            System.out.println("Введены некорректные данные");
        }


    }
}
