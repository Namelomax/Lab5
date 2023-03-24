package Second_sem.lab5;

import Second_sem.lab5.BaseClasses.Car;
import Second_sem.lab5.BaseClasses.Mood;
import com.google.gson.internal.LinkedTreeMap;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
public class Defaults {
    HashMap<String,Object> example = new HashMap<>();
    ArrayList<Number> ar_coord = new ArrayList<>();
    int[] ar_date = new int[6];
    public LinkedTreeMap<String, Object> Defaults(LinkedTreeMap<String, Object> txt){
        LinkedTreeMap<String, Object> ordered = new LinkedTreeMap<>();
        String id = WorkWithFile.readFromFile("id.txt");
        Double a = Double.parseDouble(id);
        txt.put("id",a);
        ar_coord.add(0); ar_coord.add(0);
        ar_date[0]= Main.dateOfInitialization.getYear();
        ar_date[1]= Main.dateOfInitialization.getMonthValue();
        ar_date[2]= Main.dateOfInitialization.getDayOfMonth();
        ar_date[3]= Main.dateOfInitialization.getHour();
        ar_date[4]= Main.dateOfInitialization.getMinute();
        ar_date[5]= Main.dateOfInitialization.getSecond();
        example.put("name","Bob");
        example.put("coordinates",ar_coord);
        example.put("creationDate", ar_date);
        example.put("hasToothpick",false);
        example.put("realHero",false);
        example.put("impactSpeed",100L);
        example.put("soundtrackName","Gan");
        example.put("minutesOfWaiting",5.0);
        example.put("mood", Mood.LONGING);
        example.put("car", new Car("GDV"));
        for (Map.Entry<String, Object> entry : example.entrySet()) {
            if (txt.get(entry.getKey()) == null || !txt.get(entry.getKey()).equals(txt.get(entry.getKey()))){
                txt.put(entry.getKey(),entry.getValue());}          }
        ordered.put("id",a);
        ordered.putAll(txt);
                try (FileWriter fileWriter = new FileWriter("id.txt")) {
                    fileWriter.write(Double.toString(a+1));
            } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        return ordered;}}