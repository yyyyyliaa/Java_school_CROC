package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class FilterComments implements BlackListFilter{
    public void filterComments(List<String> comments, Set<String> blackList){
        int countElements = 0;
        for (String comment : comments){
            StringBuilder res = new StringBuilder(comment);
            for(String word : blackList){
                int start = res.toString().indexOf(word);
                while(start!=-1){
                    int end = start + word.length();
                    res.replace(start, end, "***");
                    start = res.toString().indexOf(word);
                }
            }
            comments.set(countElements, res.toString());
            countElements++;
        }
    }
}
