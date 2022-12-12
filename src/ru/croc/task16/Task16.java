package ru.croc.task16;

import java.util.*;

public class Task16 {

    public static List<String> types = Arrays.asList("Эконом", "Комфорт", "Комфорт+", "Бизнес");
    public static List<String> peculiarities = Arrays.asList("Детское кресло", "Опытный водитель", "Можно с животными");
    
    public static void main(String[] args) {

        System.out.println("Введите данные в следующем формате: <Широта,Долгота>,класс комфорта,особые пожелания(пожелание1;пожелание2;...)");
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("<|>|,");

        Location location = new Location(Double.parseDouble(data[1]), Double.parseDouble(data[2]));
        String requestComfortType = data[4];
        List<String> specialRequests = Arrays.asList(data[5].split(";"));

        boolean suitableForAllSpecials = true;
        for(String w : specialRequests){
            if(!peculiarities.contains(w)){
                suitableForAllSpecials = false;
                break;
            }
        }

        if(types.contains(requestComfortType) && suitableForAllSpecials==true){
            Request test = new Request(location, requestComfortType, specialRequests);
            DriverSelectionModul dsm = new DriverSelectionModul(test);
            String resId = dsm.selectDriver();
            if(resId != null) System.out.println(dsm.selectDriver());
        }
        else{
            System.out.println("Введены некорректные данные");
        }

        sc.close();
    }
}
