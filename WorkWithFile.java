package Second_sem.lab5;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class WorkWithFile {

    public static String readFromFile(String pathToFile) {
        try {
            return new Scanner(new File(pathToFile)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static LinkedList<LinkedTreeMap> convertJSONtoLinkedList(String txt){
        return new Gson().fromJson(txt, LinkedList.class);
    }



    public static void writeInFile(String pathToFile, LinkedList<LinkedTreeMap> data){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String jsonString = gson.toJson(data);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pathToFile))) {
            bos.write(jsonString.getBytes());
        } catch (IOException|RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
