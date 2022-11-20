/*Напишите программу, которая методом полного перебора напомнит вам пароль. 
Причем за наиболее короткий срок - пароль вам нужен как можно быстрее. 
Для ускорения процесса вы решили перебор выполнять в несколько потоков.
Количество потоков - входные данные для программы, задается первым аргументом командной строки. 
Хеш пароля - вторым аргументом. Найденный пароль печатается в стандартный поток вывода.*/

package ru.croc.task9;

public class Task9 {
    public static String alphabet = "abcdefghigklmnopqrstuvwxyz";
    public static void main(String[] args) {
        // int countOfThreads = Integer.parseInt(args[0]);
        int countOfThreads = 4;
        // String passwordHash = "40682260CC011947FC2D0B1A927138C5";
        Password p = new Password();
        String tHash = p.hashPassword("abcaaac");
       
        // StringBuilder result = new StringBuilder();
        // pickUpPassword(0, result, tHash);
        for(int i = 0; i< countOfThreads; i++){
            int start = i*(alphabet.length()/countOfThreads);
            int limit;
            if(i==countOfThreads-1){
                limit = alphabet.length();
            } else {
                limit = (i+1)*(alphabet.length()/countOfThreads);
            }
            Thread t = new Thread(new MyThread(0, tHash, start, limit));
            t.start();
        }
    }
}
