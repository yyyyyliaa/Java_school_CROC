package ru.croc.task4;

class Point{
    double x;
    double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Point(){}

    public void setCoord(double x, double y){
        this.x = x;
        this.y = y;
    }
}

abstract class Figure{
    Point Point1;

    public Figure(double x1, double y1){
        Point1 = new Point(x1, y1);
    }
    @Override
    public abstract String toString();
}

class Circle extends Figure{
    double radius;
        
    public Circle(double x1, double y1, double radius){
        super(x1, y1);
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Circle (" + Point1.x + ", " + Point1.y + "), " + radius;
    }

}

class Rectangle extends Figure{
    Point Point2;

    public Rectangle(double x1, double y1, double x2, double y2){
        super(x1, y1);
        Point2 = new Point(x2, y2);
    }

    @Override
    public String toString(){
        return "Rectangle (" + Point1.x + ", " + Point1.y + "), " + "(" + Point2.x + ", " + Point2.y + ")";
    }
}

class Annotation{
    String signature;
    Figure f;

    public Annotation(String signature, Figure f){
        this.signature = signature;
        this.f = f;
    }

    @Override
    public String toString(){   
        return f.toString() + ": " + signature;
    }
}

class AnnotatedImage {

    private final String imagePath;
    private final Annotation[] annotations;
     
     
    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }
     
    public String getImagePath() {
        return this.imagePath;
    }
     
    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    @Override
    public String toString(){
        return "Annotations:\n\t" + annotations[0].toString() + "\n\t" + annotations[1].toString();
    }
}
public class Task4{
    public static void main(String[] args) {

        Circle c = new Circle(100, 100, 10);
        Rectangle r = new Rectangle(100, 100, 150, 200);

        Annotation a1 = new Annotation("kruzhochek", c);
        Annotation a2 = new Annotation("pryamougolnichek", r);

        AnnotatedImage im = new AnnotatedImage("D:/Games", a1, a2);

        System.out.println(im.toString());

    }
}