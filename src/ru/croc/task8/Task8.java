/*Напишите простую программу, которая предлагала бы пользователю ввести число в консоль и выводила его обратно 
в отформатированном виде.*/

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

