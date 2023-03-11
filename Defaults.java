package Second_sem.lab5;

import com.google.gson.internal.LinkedTreeMap;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Defaults {
    public LinkedTreeMap Defaults(LinkedTreeMap txt){
        LinkedTreeMap<String, Object> b = Main.listOfData.get(0);
        if (!txt.containsKey("id")) {
            String line1 = WorkWithFile.readFromFile("id.txt");
            double a = Double.parseDouble(line1);
            System.out.println(a);
            txt.put("id",a);
            File file = new File("id.txt");
                try (FileWriter fileWriter = new FileWriter("id.txt")) {
                    fileWriter.write(Double.toString(a+1));
            } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
        if (!txt.containsKey("name")) {
            txt.put("name","Bob");
        }
        if (!txt.containsKey("coordinates")) {
            ArrayList<Number> ar_coord = new ArrayList<>(); ar_coord.add(0); ar_coord.add(0);
            txt.put("coordinates",ar_coord);
        }
        if (!txt.containsKey("creationDate")) {
            ArrayList<Number> ar_date = new ArrayList<>();ar_date.add(2020.0);ar_date.add(3.0); ar_date.add(8.0); ar_date.add(23.0); ar_date.add(48.0); ar_date.add(30.0);
            txt.put("coordinates",ar_date);
        }
        if (!txt.containsKey("realHero")) {
            txt.put("realHero",false);
        }
        if (!txt.containsKey("hasToothpick")) {
            txt.put("hasToothpick",false);
        }
        if (!txt.containsKey("impactSpeed")) {
            txt.put("impactSpeed",Long.toString(100));
        }
        if (!txt.containsKey("soundtrackName")) {
            txt.put("soundtrackName","Gan");
        }
        if (!txt.containsKey("minutesOfWaiting")) {
            txt.put("minutesOfWaiting",(Double.toString(5.0)));
        }
        if (!txt.containsKey("mood")) {
            txt.put("mood","LONGING");
        }
        if (!txt.containsKey("car")) {
            txt.put("car","GDV");
        }
        return txt;
    }
}
