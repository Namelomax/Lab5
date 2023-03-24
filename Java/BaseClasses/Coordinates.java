package Second_sem.lab5.Java.BaseClasses;

import java.util.ArrayList;

public class Coordinates {
    private double x; //Максимальное значение поля: 36
    private Float y; //Значение поля должно быть больше -821, Поле не может быть null

    @Override
    public String toString() {
        return "["+x+"; "+y+"]";
    }

    public Coordinates(double x, Float y){
        this.x = x;
        this.y = y;
    }
    public Coordinates(ArrayList<Number> array){
        this.x=(double) array.get(0);
        Double unzipY = (Double) array.get(1);
        this.y= unzipY.floatValue();
    }
}
