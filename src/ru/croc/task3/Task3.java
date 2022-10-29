package ru.croc.task3;

public class Task3{

    static class Point{
        double x;
        double y;
    }

    public static double SquareTriangle(Point a, Point b, Point c){
        double len1 = Math.sqrt(Math.pow((a.x-b.x),2)+Math.pow((a.y-b.y),2));
        double len2 = Math.sqrt(Math.pow((a.x-c.x),2)+Math.pow((a.y-c.y),2));
        double len3 = Math.sqrt(Math.pow((c.x-b.x),2)+Math.pow((c.y-b.y),2));
        double p = (len1+len2+len3)/2;
        double res = Math.sqrt(p*(p-len1)*(p-len2)*(p-len3));
        return res;
    }

    public static void main(String[] args) {
        Point a = new Point();
        a.x = Double.parseDouble(args[0]);
        a.y = Double.parseDouble(args[1]);

        Point b = new Point();
        b.x = Double.parseDouble(args[2]);
        b.y = Double.parseDouble(args[3]);

        Point c = new Point();
        c.x = Double.parseDouble(args[4]);
        c.y = Double.parseDouble(args[5]);

        double res = SquareTriangle(a, b, c);
        System.out.println("Square triangle:" + res);

    }
}
