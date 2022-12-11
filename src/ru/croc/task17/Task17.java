package ru.croc.task17;

import java.util.*;

public class Task17 {
    public static void main(String[] args) {
        List<String> data = CSVProcessing.fromCSVtoSetString(args[0]);

        DBHandler.createTablesAndInsertData("jdbc:h2:./test", "sa", "1", data);
        DBHandler.showDB("jdbc:h2:./test", "sa", "1");
    }
}
