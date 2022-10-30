package ru.croc.Task2;

public class Task2 {

    public static int SumArifmeticProgression(int start, int dif, int count){
        int res = 0;
        int cur = start;
        for(int i = 0; i<count; i++, cur+=dif){
            res += cur;
        }
        return res;
    }

    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);
        int dif = Integer.parseInt(args[1]);
        int count = Integer.parseInt(args[2]);

        int res = SumArifmeticProgression(start, dif, count);
        System.out.println("Sum = " + res);
    }
}
