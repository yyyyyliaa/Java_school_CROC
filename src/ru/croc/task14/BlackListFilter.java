package ru.croc.task14;

import java.util.*;
import java.util.function.Predicate;


public interface BlackListFilter<T> {
    default List<T> filterComments(Collection<T> comments, Predicate<T> filter){
        List<T> result = new ArrayList<>();
        for(T com : comments){
            if(filter.test(com)==false){
                result.add(com);
            }
        }
        return result;
    }
}
