package ru.croc.FinalProject;

import java.util.HashSet;
import java.util.Set;

public class User {
    private Set<String> resolvedTasks = new HashSet<>();
    private Set<String> unresolvedTasks = new HashSet<>();
    
    public User(){};

    public boolean checkCompletedTask(String task){
        return (resolvedTasks.contains(task) ||  unresolvedTasks.contains(task));
    }

    public void markTaskResolved(String task){
            resolvedTasks.add(task);
    }

    public void markTaskUnresolved(String task){
        unresolvedTasks.add(task);
    }

    public Integer getCompletedTasksCount(){
        return resolvedTasks.size() + unresolvedTasks.size();
    }

    public Integer getResolvedTasksCount(){
        return resolvedTasks.size();
    }
}
