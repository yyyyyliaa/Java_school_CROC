package ru.croc.FinalProject;

import java.util.HashSet;
import java.util.Set;

public class CurrentUserData {
    private Set<String> resolvedTasks = new HashSet<>();
    private Set<String> unresolvedTasks = new HashSet<>();
    
    public CurrentUserData(){};

    public boolean checkCompletedTask(String task){
        return (resolvedTasks.contains(task) ||  unresolvedTasks.contains(task));
    }

    public void markTaskResolved(String task){
        if(!resolvedTasks.contains(task)){
            resolvedTasks.add(task);
        }
    }

    public void markTaskUnresolved(String task){
        if(!unresolvedTasks.contains(task)){
            unresolvedTasks.add(task);
        }
    }

    public Integer getCompletedTasksCount(){
        return resolvedTasks.size() + unresolvedTasks.size();
    }

    public Integer getResolvedTasksCount(){
        return resolvedTasks.size();
    }

    public Integer getUnresolvedTasksCount(){
        return unresolvedTasks.size();
    }
}
