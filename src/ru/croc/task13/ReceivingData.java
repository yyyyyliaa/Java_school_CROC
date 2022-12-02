package ru.croc.task13;

import java.util.*;
import java.io.*;

public abstract class ReceivingData {

    public static Map<Integer, String> getFilms(String filmsPath){
        Map<Integer, String> res = new HashMap<>();
        try{

            File f = new File(filmsPath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            while(line!=null){
                String[] film = line.split(",");
                res.put(Integer.parseInt(film[0]), film[1]);
                line = br.readLine();
            }
            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static List<String[]> getViewHistory(String viewHistoryPath){
        List<String[]> res = new LinkedList<>();
        try{

            File f = new File(viewHistoryPath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String history = br.readLine();
            while(history!=null){
                res.add(history.split(","));
                history = br.readLine();
            }
            br.close();
            fr.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
    
}
