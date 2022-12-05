package ru.croc.task16;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude, double longitude){
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static double cmp(Location l1, Location l2){
        return Math.sqrt(Math.pow(l1.latitude - l2.latitude,2) + Math.pow(l1.longitude - l2.longitude,2));
    }
}
