package ru.croc.task16;

import java.util.*;

public class Request {
    private Location location;
    private String requestType;
    private List<String> wishes;

    public Request(Location location, String requestType, List<String> wishes){
        this.location = location;
        this.requestType = requestType;
        this.wishes = wishes;
    }

    public Location getLocation(){
        return location;
    }

    public String getRequestType(){
        return requestType;
    }

    public List<String> getWishes(){
        return wishes;
    }
}

