package ru.croc.task16;

import java.util.*;

public class Driver {

    private String id;
    private Location location;
    private String type;
    private List<String> specials;

    public Driver(String id, Location location, String type, List<String> specials){
        this.id = id;
        this.location = location;
        this.type = type;
        this. specials = specials;
    }

    public String getID(){
        return id;
    }

    public Location getLocation(){
        return location;
    }

    public String getType(){
        return type;
    }

    public List<String> getPeculiaties(){
        return specials;
    }
}
