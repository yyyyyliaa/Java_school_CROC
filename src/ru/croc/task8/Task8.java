/*Напишите простую программу, которая предлагала бы пользователю ввести число в консоль и выводила его обратно 
в отформатированном виде.
Шаг 1: предлагаем пользователю ввести данные, которые позволят нам создать Locale. Если пользователь пропустил ввод этих данных (пустая строка), то используем дефолтную Locale (любую, как и в условии выше).

Шаг 2: просим ввести число.

Шаг 3: Выводим число, отформатированное в соответствии с введёнными пользователем данными.
Предусмотрите обработку возможных ошибок при вводе данных на шаге 1.*/

package ru.croc.task8;

import java.util.Scanner;

public class Task8 {
    public static void main(String[] args){
        int number = 0;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number (required field): ");
        if (s.hasNextInt()){ 
            number = s.nextInt();
        }
        else {
            System.out.print("The entered value is not a number");
        }
         s.close();
    
        Price p = new Price(number);
        System.out.println(p.formatPrice());
    }
   }

