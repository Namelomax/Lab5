package Second_sem.lab5;

import Second_sem.lab5.Commands.AddCommand;
import Second_sem.lab5.Commands.ConsoleCommand;
import Second_sem.lab5.Commands.HelpCommand;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static String path;
    public static LinkedList<LinkedTreeMap<String, Object>> listOfData;
    public static LinkedList<HumanBeing> listOfHumanBeing;

    public static void main(String[] args) {
        path = "D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Data.json";
        String data = WorkWithFile.readFromFile(path);
        listOfData = WorkWithFile.convertJSONtoLinkedList(data);
        listOfHumanBeing = makeListOfHumanBeing(listOfData);
        ConsoleCommand consoleCommand = new ConsoleCommand();
        ArrayList<Number> ar_coord = new ArrayList<>(); ar_coord.add(5.245); ar_coord.add(25.56);
        ArrayList<Number> ar_date = new ArrayList<>();ar_date.add(2023.0);ar_date.add(3.0); ar_date.add(8.0); ar_date.add(23.0); ar_date.add(48.0); ar_date.add(30.0);
        Object[] test = {3.0, "Jane", ar_coord, ar_date, true, true, 123.0, "The Box", 1.3, "LONGING", "peugeout 308"};
        Object[] test2 = {3.0, "Jane", ar_coord, ar_date, false, false, 123.0, "Rumbling", 1.2, "LONGING", "peugeout 307"};



    }

    private static LinkedList<HumanBeing> makeListOfHumanBeing(LinkedList<LinkedTreeMap<String, Object>> data) {
        LinkedList<HumanBeing> listOfHumanBeing = new LinkedList<>();
        for (LinkedTreeMap<String, Object> datum : data) {
            HumanBeing unit = new HumanBeing(LinkedTreeMapCommander.getParams((LinkedTreeMap<String, Object>) datum));
            listOfHumanBeing.add(unit);
        }
        return listOfHumanBeing;}

}
