package ru.croc.task13;

import java.util.*;

public class Recomendations {

    private Map<Integer, String> films = new HashMap<>();
    private List<String[]> viewHistory = new LinkedList<>();

    public Recomendations(String filmsPath, String viewHistoryPath){
        this.films = GetData.setFilms(filmsPath);
        this.viewHistory = GetData.setViewHistory(viewHistoryPath);
    }

    public Set<String> getSuitableFilms(String[] viewHistoryUser){
        Set<String> res = new HashSet<>();
        for(String[] history : viewHistory){
            int countCoincidences = 0;
            for(int i = 0; i < viewHistoryUser.length; i++){
                for (int j = 0; j<history.length; j++){
                    if(viewHistoryUser[i].equals(history[j])) countCoincidences++;
                }
            }
            if (countCoincidences>=(viewHistoryUser.length/2)) {
                for(int i = 0; i<history.length; i++){
                    Boolean filmViewed = false;
                    for(int j = 0; j<viewHistoryUser.length; j++){
                        if(history[i].equals(viewHistoryUser[j])){
                            filmViewed = true;
                        }
                    }
                    if(!filmViewed) res.add(history[i]);
                }
            }
        }
        return res;
    }

    public int getBestMatches(Set<String> suitableFilms){
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

        return Integer.parseInt(bestMatches);
    }

    public void getRecomendations(User user){
        String[] viewHistoryUser = user.getViewHistory();
        Set<String> suitableFilms = getSuitableFilms(viewHistoryUser);


        int bestMatches = getBestMatches(suitableFilms);

        if(bestMatches!=0)
            System.out.println(films.get(bestMatches));
    }
    
}
