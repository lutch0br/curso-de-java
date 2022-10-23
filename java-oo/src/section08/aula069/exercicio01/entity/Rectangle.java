package section08.aula069.exercicio01.entity;


public class Rectangle {

    public double width;
    public double height;

    public double area(){
        return width * height;
    }    

    public double perimeter(){
        return 2 * (width + height);
    }

    public double diagonal(){
        return Math.sqrt(Math.pow(height, 2) + Math.pow(width, 2));
    }
}