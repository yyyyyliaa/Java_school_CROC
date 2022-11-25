package ru.croc.task12;

import java.util.*;


public class Task12 {
    public static void main(String[] args) {
        String[] commentsArray = {
                "Wonderful",
                "This is a piece of shit",
                "You must watch this video https://www.youtube.com/watch?v=hEblHlT3Nas",
                "Thank you!",
                "Fuck you",
                "Follow me in Instagram!!! @yyyyyliaa",
                "I hate cats"
        };
        String[] swearWordsArray = {
                "Fuck", "shit", "hate cats"
        };
        List<String> comments = new LinkedList<>(Arrays.asList(commentsArray));
        Set<String> blackList = new HashSet<>(Arrays.asList(swearWordsArray));
        BlackListFilter f = new FilterComments();
        f.filterComments(comments, blackList);
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
    
}
