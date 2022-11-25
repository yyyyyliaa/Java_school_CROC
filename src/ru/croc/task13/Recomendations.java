package ru.croc.task13;

import java.util.*;
import java.io.*;

public class Recomendations {

    private Map<Integer, String> films = new HashMap<>();
    private List<String[]> viewHistory = new LinkedList<>();

    public Recomendations(String filmsPath, String viewHistoryPath){
        try{
            File f = new File(viewHistoryPath);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String history = br.readLine();
            while(history!=null){
                viewHistory.add(history.split(","));
                history = br.readLine();
            }
            br.close();
            fr.close();



            f = new File(filmsPath);
            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String line = br.readLine();
            while(line!=null){
                String[] film = line.split(",");
                films.put(Integer.parseInt(film[0]), film[1]);
                line = br.readLine();
            }
            br.close();
            fr.close();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getRecomendations(String history){
        String[] viewHistoryUser = history.split(",");
        List<String[]> suitableUsers = new LinkedList<>();
        Set<String> suitableFilms = new HashSet<>();
        for(String[] his : viewHistory){
            int countCoincidences = 0;
            for(int i = 0; i < viewHistoryUser.length; i++){
                for (int j = 0; j<his.length; j++){
                    if(viewHistoryUser[i].equals(his[j])) countCoincidences++;
                }
            }
            if (countCoincidences>=(viewHistoryUser.length/2)) {
                suitableUsers.add(his);
                for(int i = 0; i<his.length; i++){
                    int flag = 0;
                    for(int j = 0; j<viewHistoryUser.length; j++){
                        if(his[i].equals(viewHistoryUser[j])){
                            flag = 1;
                            break;
                        }
                    }
                    if(flag==0) suitableFilms.add(his[i]);
                }
            }
        }


        String bestMatches = "0";
        int maxCountView = 0;
        Iterator<String> it = suitableFilms.iterator();
        while (it.hasNext()){
            String cur = it.next();
            int countView = 0;
            for(String[] his : viewHistory){
                for(String i : his){
                    if(cur.equals(i)) countView++;
                }
            }
            if (countView>maxCountView) {
                maxCountView = countView;
                bestMatches = cur;
            }
        }

        if(!bestMatches.equals("0"))
            System.out.println(films.get(Integer.parseInt(bestMatches)));
    }
    
}
