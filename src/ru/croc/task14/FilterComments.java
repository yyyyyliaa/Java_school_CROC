package ru.croc.task14;

import java.util.*;
import java.util.function.Predicate;

public class FilterComments<T> implements BlackListFilter<T>{

    Predicate<T> filter;

    public FilterComments(Predicate<T> filter){
        this.filter = filter;
    }

    public List<T> filterComments(Collection<T> comments){
        return filterComments(comments, filter);
    }
}
