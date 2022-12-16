package ru.croc.FinalProject;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class EnglishTestBot {

    private Storage storage;
    private List<String> comands = Arrays.asList("/start", "/stop");

    public EnglishTestBot(String tasksFilePath){
        storage = new Storage(tasksFilePath);
    }

    public void startTest(){
        getBotInfo();

        CurrentUserData user = new CurrentUserData();

        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        while(!comands.contains(answer)){
            System.out.println("Введена некорректная команда! Пожалуйста, повторите ввод.");
            answer = sc.nextLine();
        }
        while(!answer.equals("/stop")){
            System.out.println("Задание: Вставьте на место пропуска слово в скобках, предварительно преобразовав его в нужную форму:");
            int numTask = (int)(Math.random() * (storage.getTasksCount()+1));
            String task = storage.getTask(numTask);
            while(user.checkCompletedTask(task)){
                numTask = (int)Math.random() * (storage.getTasksCount()+1);
                task = storage.getTask(numTask);
            }
            System.out.println(task);
            System.out.println("Ваш ответ:");
            
            answer = sc.nextLine();

            if(answer.equals(storage.getAnswer(numTask))){
                System.out.println("Верный ответ! Продолжаем!");
                user.markTaskResolved(task);
            } else if (!answer.equals("/stop")){
                System.out.println("Не верно :(");
                System.out.println("Правильный ответ:" + storage.getAnswer(numTask));
                user.markTaskUnresolved(task);
            }
        }
        if(answer.equals("/stop")){
            System.out.println("Тестирование окончено!");
            System.out.print("Всего решено заданий:");
            System.out.println(user.getCompletedTasksCount());

            System.out.print("Из них решено верно:");
            System.out.println(user.getResolvedTasksCount());
        }
        sc.close();
    }

    public void getBotInfo(){
    System.out.println("Привет! Я бот, который поможет отработать пройденные темы по английскому языку на практике. ");
    System.out.println("Для того, чтобы начать введите команду /start");
    System.out.println("Если захотите закончить, введите команду /end");
    }

}


