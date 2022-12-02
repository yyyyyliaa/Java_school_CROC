package ru.croc.task13;

import java.util.Scanner;

public class Task13 {

    public static void main(String[] args) {
        String filmsPath = "src/ru/croc/task13/films.txt";
        String vievHistoryPath = "src/ru/croc/task13/viewHistory.txt";

        Recomendations rec = new Recomendations(filmsPath, vievHistoryPath);

        System.out.print("Enter the numbers of the films you have watched: ");
        Scanner sc = new Scanner(System.in);
        String history = sc.nextLine();

        User user = new User(history);

        rec.pickUpRecomendations(user);
        
        sc.close();
    }
}
