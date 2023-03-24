package Second_sem.lab5.Java.BaseClasses;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class HumanBeing implements Comparable<HumanBeing> {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Boolean realHero; //Поле не может быть null
    private Boolean hasToothpick; //Поле не может быть null
    private long impactSpeed;
    private String soundtrackName; //Поле не может быть null
    private Double minutesOfWaiting; //Поле может быть null
    private Mood mood; //Поле может быть null
    private Car car; //Поле может быть null

    public HumanBeing(int id, String name, Coordinates coordinates, LocalDateTime creationDate, Boolean realHero, Boolean hasToothpick, long impactSpeed, String soundtrackName, Double minutesOfWaiting, Mood mood, Car car) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.realHero = realHero;
        this.hasToothpick = hasToothpick;
        this.impactSpeed = impactSpeed;
        this.soundtrackName = soundtrackName;
        this.minutesOfWaiting = minutesOfWaiting;
        this.mood = mood;
        this.car = car;
    }

    public HumanBeing(Object[] array){
        Double unzipId = (Double) array[0];
        this.id = unzipId.intValue();
        this.name = (String) array[1];
        this.coordinates = new Coordinates((ArrayList<Number>) array[2]);
        ArrayList<Double> unzipDate = (ArrayList<Double>)array[3];
        this.creationDate = LocalDateTime.of(unzipDate.get(0).intValue(), unzipDate.get(1).intValue(), unzipDate.get(2).intValue(), unzipDate.get(3).intValue(), unzipDate.get(4).intValue(), unzipDate.get(5).intValue());
        this.realHero = (Boolean) array[4];
        this.hasToothpick = (Boolean) array[5];
        Double unzipSpeed = (Double) array[6];
        this.impactSpeed = unzipSpeed.longValue();
        this.soundtrackName = (String) array[7];
        this.minutesOfWaiting = (Double) array[8];
        this.mood = Mood.valueOf((String) array[9]);
        this.car = new Car((String) array[10]);
    }
    public HumanBeing(){};

    @Override
    public int compareTo(@NotNull HumanBeing o) {
        return Integer.compare(this.id, o.id);
    }
    public Double getId() {
        return (double) id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getRealHero() {
        return realHero;
    }

    public void setRealHero(Boolean realHero) {
        this.realHero = realHero;
    }

    public Boolean getHasToothpick() {
        return hasToothpick;
    }

    public void setHasToothpick(Boolean hasToothpick) {
        this.hasToothpick = hasToothpick;
    }

    public long getImpactSpeed() {
        return impactSpeed;
    }

    public void setImpactSpeed(long impactSpeed) {
        this.impactSpeed = impactSpeed;
    }

    public String getSoundtrackName() {
        return soundtrackName;
    }

    public void setSoundtrackName(String soundtrackName) {
        this.soundtrackName = soundtrackName;
    }

    public Double getMinutesOfWaiting() {
        return minutesOfWaiting;
    }

    public void setMinutesOfWaiting(Double minutesOfWaiting) {
        this.minutesOfWaiting = minutesOfWaiting;
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        String txt = "\n\nid: "+id+"\nname: "+name+"\ncoordinates: "+coordinates+"\ncreation date: "
                +creationDate+"\nreal hero: "+realHero+"\nhas toothpick: "+hasToothpick+"\nimpact speed: "+impactSpeed+
                "\nsoundtrack name: "+soundtrackName+"\nminutes of waiting: "+minutesOfWaiting+"\nmood: "+mood+ "\ncar: "+car;
        return txt;
    }
}

