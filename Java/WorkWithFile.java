package Second_sem.lab5.Java;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class WorkWithFile {
    /**
     * Reads all text from file.
     * @param pathToFile path to the file.
     * @return String which contains all data from file.
     * @author KruglovEgor
     */
    public static String readFromFile(String pathToFile) {
        try {
            return new Scanner(new File(pathToFile)).useDelimiter("\\Z").next();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Convert json data to Linked list.
     * @param txt the json data in format of String.
     * @return LinkedList<LinkedTreeMap<String, Object>> with fields and their values for creating HumanBeing unit.
     * @author KruglovEgor
     */
    public static LinkedList<LinkedTreeMap<String, Object>> convertJSONtoLinkedList(String txt){
        return new Gson().fromJson(txt, LinkedList.class);
    }


    /**
     * Write json-data in json file.
     * @param pathToFile path to the json file.
     * @param data LinkedList<LinkedTreeMap<String, Object>> with information about units of HumanBeing.
     * @author KruglovEgor
     */
    public static void writeInJSONFile(String pathToFile, LinkedList<LinkedTreeMap<String, Object>> data){
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String jsonString = gson.toJson(data);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(pathToFile))) {
            bos.write(jsonString.getBytes());
        } catch (IOException|RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Writes String data in file.txt.
     * @param pathToFile path to file.txt
     * @param data String for writing in file.
     * @author KruglovEgor
     */
    public static void writeInTxtFile(String pathToFile, String data){
        try (FileWriter fileWriter = new FileWriter(pathToFile)){
            fileWriter.write(data);
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}