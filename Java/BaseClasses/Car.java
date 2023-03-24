package Second_sem.lab5.Java.BaseClasses;

public class Car {
    private String name; //Поле не может быть null
    public Car(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }
}
