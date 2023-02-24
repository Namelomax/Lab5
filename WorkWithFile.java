package Second_sem.lab5;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
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

    public static LinkedList convertJSONtoLinkedList(String txt){
        return new Gson().fromJson(txt, LinkedList.class);
    }
}
