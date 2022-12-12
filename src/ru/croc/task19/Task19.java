package ru.croc.task19;

public class Task19 {
    public static void main(String[] args) {
        DBHandler.createTables("jdbc:h2:./test", "sa", "1");
        DBHandler.showDB("jdbc:h2:./test", "sa", "1");

    }

    
}
