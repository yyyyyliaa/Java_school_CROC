/*
1. Условия фильтрации в разных сервисах различаются и нет возможности обобщить их в рамках одного метода. 
Поэтому способ фильтрации вы решаете представлять в виде предиката и позволять определять его вызывающим сервисам.

2. Набор используемых сервисами классов-представлений для комментариев обширен (String, Comment, CommentDto, …) и, 
возможно, будет и в дальнейшем расширяться.

3. Сервисы работают с наборами комментариев в виде коллекций разных типов (HashSet, ArrayList, ArrayDeque, …),
 но все они имплементируют интерфейс Iterable.

4. Результат фильтрации удобнее представлять в виде отдельной коллекции-возвращаемого значения метода, 
а исходную коллекцию при этом не модифицировать. Некоторым сервисам важен порядок следования комментариев, 
поэтому он должен быть сохранен в отфильтрованном результате.

Обновите интерфейс BlackListFilter и реализуйте новый механизм фильтрации в виде default-метода.*/


package ru.croc.task14;

import java.util.*;
// import java.io.*;
import java.util.function.Predicate;

public class Task14 {
    public static String[] commentsArray = {
        "Wonderful",
        "This is a piece of shit",
        "You must watch this video https://www.youtube.com/watch?v=hEblHlT3Nas",
        "Thank you!",
        "Fuck you",
        "Follow me in Instagram!!! @yyyyyliaa",
        "I hate cats"
    };

    public static String[] wordsArray = {
        "Fuck", "shit", "hate cats"
    };

    public static List<String> comments = new LinkedList<>(Arrays.asList(commentsArray));
    public static Set<String> blackList = new HashSet<>(Arrays.asList(wordsArray));

    public static Predicate<String> filter = (String comment) -> {
        StringBuilder res = new StringBuilder(comment);
        int start = -1;
        for(String word : blackList){
            start = res.toString().indexOf(word);
            if (start!=-1) return true;
        }
        return false;
    };


    public static void main(String[] args) {

        FilterComments<String> test = new FilterComments<>(filter);

        List<String> commentsAfterFiltering = test.filterComments(comments, filter);

        System.out.println(commentsAfterFiltering.toString());
        
    }
}
