/*Напишите программу, которая методом полного перебора напомнит вам пароль. 
Причем за наиболее короткий срок - пароль вам нужен как можно быстрее. 
Для ускорения процесса вы решили перебор выполнять в несколько потоков.
Количество потоков - входные данные для программы, задается первым аргументом командной строки. 
Хеш пароля - вторым аргументом. Найденный пароль печатается в стандартный поток вывода.*/

package ru.croc.task9;

public class Task9 {
    public static String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        int passwordLength = 7;
        
        // int countOfThreads = Integer.parseInt(args[0]);
        //String passwordHash = args[1];

        int countOfThreads = 30;
        String passwordHash = Hash.hashPassword("afkvrqe");
        System.out.println("Password hash: " + passwordHash);

        long countPasswordCombinations = (int)Math.pow(passwordLength, alphabet.length());
        Thread[] t = new Thread[countOfThreads];

        for(int i = 0; i<countOfThreads; i++){
            long start = (countPasswordCombinations*i)/countOfThreads;
            long end = (countPasswordCombinations*(i+1))/countOfThreads;
            t[i] = new Thread(new MyThread(start, end, passwordHash));
            t[i].start();
        }
    }
}
