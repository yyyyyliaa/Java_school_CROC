package ru.croc.task16;

import java.util.*;

public class DriverSelectionModul{
    private static List<String> types = Arrays.asList("Эконом", "Комфорт", "Комфорт+", "Бизнес");
    private static List<String> peculiarities = Arrays.asList("Детское кресло", "Опытный водитель", "Можно с животными");
    private static String[] driversRawInfo = {
        "1-60.023690,30.623611-Комфорт-Детское кресло",
        "2-60.030804,30.638130-Эконом-Детское кресло,Опытный водитель",
        "3-59.946764,30.411871-Комфорт+-Детское кресло,Опытный водитель",
        "4-59.984339,30.426037-Эконом-Можно с животными,Опытный водитель",
        "5-59.940817,30.206875-Бизнес-Детское кресло,Опытный водитель",
        "6-59.963768,30.553427-Эконом- ",
        "7-59.925214,30.320428-Комфорт+-Опытный водитель",
        "8-60.038450,30.663769-Комфорт-Можно с животными",
        "9-59.977496,30.402943-Комфорт+-Детское кресло,Можно с животными",
        "10-60.016847,30.646851-Эконом-Детское крсло",
        "11-60.018525,30.596409-Эконом-Опытный водитель",
        "12-60.024754,30.645988-Комфорт+-Можно с животными",
        "13-60.024371,30.666798-Бизнес-Опытный водитель",
        "14-60.099825,30.788189-Бизнес-Детское кресло",
        "15-60.079811,30.940716-Эконом-Детское кресло,Можно с животными"
    };
    private  static List<Driver> drivers = driversDataProcessing();

    private Request request;

    public DriverSelectionModul(Request request){
        this.request = request;
    }
    
    public static List<Driver> driversDataProcessing(){
        List<Driver> result = new ArrayList<>();
        Driver tmp;
        for(String s : driversRawInfo){
            String[] curDriver = s.split("-");

            String[] location = curDriver[1].split(",");
            double lat = Double.parseDouble(location[0]);
            double lon = Double.parseDouble(location[1]);

            List<String> specials = Arrays.asList(curDriver[3].split(","));

            if((lat>=0)&&(lon>=0)&&(types.contains(curDriver[2]))&&(peculiarities.containsAll(specials))){
                tmp = new Driver(curDriver[0], new Location(lat, lon), curDriver[2], specials);
                result.add(tmp);
            }
        }
        return result;
    }


    public String selectDriver(){
        List<Driver> sortedDrivers = new ArrayList<>(drivers);
        sortedDrivers.sort((driver1, driver2)->{
            if(driver1.getType().equals(request.getRequestType())==driver2.getType().equals(request.getRequestType())==true){

                if(request.getWishes().containsAll(driver1.getPeculiaties()) == request.getWishes().containsAll(driver2.getPeculiaties()) == true){
                    double driver1Distance = Location.cmp(driver1.getLocation(), request.getLocation());
                    double driver2Distance = Location.cmp(driver2.getLocation(), request.getLocation());
                    if(driver1Distance==driver1Distance) return 0;
                    else{
                        if(driver1Distance>driver2Distance) return 1;
                        else return -1;
                    }
                } else {
                    if(request.getWishes().containsAll(driver2.getPeculiaties()) == true) return 1;
                    else return -1;
                }
            } else{
                if(driver2.getType().equals(request.getRequestType())==true) return 1;
                else return -1;
            }
        });
        Driver suitableDriver = sortedDrivers.get(0);
        if(suitableDriver.getPeculiaties().containsAll(request.getWishes()) && request.getRequestType().equals(suitableDriver.getType())) return suitableDriver.getID();
        else{
            System.out.println("Подходящего водителя не найдено");
            return null;
        }
    }
}