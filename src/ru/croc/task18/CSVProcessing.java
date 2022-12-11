package ru.croc.task18;

import java.util.*;
import java.io.*;

public abstract class CSVProcessing {
    public static List<String> fromCSVtoSetString(String filePath){
        List<String> result = new ArrayList<>();
        try{
            File f = new File(filePath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while(line!=null){
                result.add(line);
                line = br.readLine();
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}