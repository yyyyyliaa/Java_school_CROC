package ru.croc.FinalProject;


import java.util.Scanner;


public class EnglishTest {

    private Storage storage;
    private User user;

    public EnglishTest(String tasksFilePath){
        storage = new Storage(tasksFilePath);
    }

    public void startTest(){
        getBotInfo();

        user = new User();

        Scanner sc = new Scanner(System.in);
        String userMessage = sc.nextLine();

        while(!userMessage.equals("/start")){
            System.out.println("Введена некорректная команда! ");
            System.out.println("Для того, чтобы начать введите команду /start");
            System.out.println("Если захотите закончить, введите команду /end");

            userMessage = sc.nextLine();
        }


        while(!userMessage.equals("/stop")){
            userMessage = startCommand();
        }

        System.out.println("Тестирование окончено!");
        System.out.print("Всего решено заданий:");
        System.out.println(user.getCompletedTasksCount());

        System.out.print("Из них решено верно:");
        System.out.println(user.getResolvedTasksCount());

        sc.close();
    }

    public String startCommand(){
        System.out.println("Задание: Вставьте на место пропуска слово в скобках, предварительно преобразовав его в нужную форму:");
        int numTask = (int)(Math.random() * (storage.getTasksCount()));
        String task = storage.getTask(numTask);
        while(user.checkCompletedTask(task)){
            numTask = (int)Math.random() * (storage.getTasksCount());
            task = storage.getTask(numTask);
        }
        System.out.println(task);
        System.out.println("Ваш ответ:");
        
        Scanner sc = new Scanner(System.in);
        String answer = sc.nextLine();

        if(answer.equals(storage.getAnswer(numTask))){
            System.out.println("Верный ответ! Продолжаем!\n");
            user.markTaskResolved(task);
        } else if (!answer.equals("/stop")){
            System.out.println("Не верно :(");
            System.out.println("Правильный ответ: " + storage.getAnswer(numTask) + "\n");
            user.markTaskUnresolved(task);
        }else{
            sc.close();
        }
        return answer;
    }

    public void getBotInfo(){
    System.out.println("Привет! Эта программа предназначена для отработки пройденных тем по английскому языку на практике! ");
    System.out.println("Для того, чтобы начать введите команду /start");
    System.out.println("Если захотите закончить, введите команду /end");
    }

}


