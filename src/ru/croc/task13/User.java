package ru.croc.task13;

public class User {
    private String[] viewHistoryUser;


    public User(String viewHistoryUser){
        this.viewHistoryUser = viewHistoryUser.split(",");
    }

    public String[] getViewHistory(){
        return viewHistoryUser;
    }
}
