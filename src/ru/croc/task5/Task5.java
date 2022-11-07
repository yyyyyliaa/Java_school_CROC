package ru.croc.task5;

class Point{
    int x;
    int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(){}

    public void setCoord(int x, int y){
        this.x = x;
        this.y = y;
    }
}


interface Movable{ 
    void move(int dx, int dy);
}

abstract class Figure implements Movable{
    Point Point1;

    public Figure(int x1, int y1){
        Point1 = new Point(x1, y1);
    }

    @Override
    public abstract String toString();

    public abstract boolean searchPoint(int x, int y);

}

class Circle extends Figure{
    int radius;
        
    public Circle(int x1, int y1, int radius){
        super(x1, y1);
        this.radius = radius;
    }

    @Override
    public String toString(){
        return "Circle (" + Point1.x + ", " + Point1.y + "), " + radius;
    }

    @Override
    public void move(int dx, int dy){
        Point1.x += dx;
        Point1.y += dy;
    }

    @Override
    public boolean searchPoint(int x, int y){
        if(Math.sqrt(Math.pow(x-this.Point1.x, 2)+(Math.pow(y-this.Point1.y, 2)))<=this.radius){
            return true;
        }
        else return false;
    }

}


class Rectangle extends Figure{
    Point Point2;

    public Rectangle(int x1, int y1, int x2, int y2){
        super(x1, y1);
        Point2 = new Point(x2, y2);
    }

    @Override
    public String toString(){
        return "Rectangle (" + Point1.x + ", " + Point1.y + "), " + "(" + Point2.x + ", " + Point2.y + ")";
    }

    @Override
    public void move(int dx, int dy){
        Point1.x += dx;
        Point1.y += dy;

        Point2.x += dx;
        Point2.y += dy;
    }

    @Override
    public boolean searchPoint(int x, int y){
        if(((x<=(Math.max(this.Point1.x, this.Point2.x)))&&(x>=(Math.min(this.Point1.x, this.Point2.x))))
        &&((y<=(Math.max(this.Point1.y, this.Point2.y)))&&(y>=(Math.min(this.Point1.y, this.Point2.y))))){
            return true;
        }
        else return false;
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

    public Annotation findByPoint(int x, int y){
        for(Annotation tmp : annotations){
            if(tmp.f.searchPoint(x, y)==true){
                return tmp;
            }
        }
        return null;
    }

    public Annotation findByLabel(String label){
        for(Annotation tmp : annotations){
            if(tmp.signature.contains(label)){
                return tmp;
            } 
        }
        return null;
    }
}
public class Task5{
    public static void main(String[] args) {

        Circle c = new Circle(100, 100, 10);
        Rectangle r = new Rectangle(100, 100, 150, 200);

        Annotation a1 = new Annotation("kruzhochek", c);
        Annotation a2 = new Annotation("pryamougolnichek", r);

        AnnotatedImage im = new AnnotatedImage("D:/Games", a1, a2);

        System.out.println("Find by point result: " + im.findByPoint(110, 110));
        System.out.println("Find by lable result: " + im.findByLabel("pryamoug"));

        c.move(5, 5); 
        System.out.println("Result after move: " + c.toString());

        r.move(10, 10);
        System.out.println("Result after move: " + r.toString());
    }
}
