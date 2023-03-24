package Second_sem.lab5.Java;

import Second_sem.lab5.Java.BaseClasses.HumanBeing;
import Second_sem.lab5.Java.Commands.*;
import com.google.gson.internal.LinkedTreeMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static String path;
    /**
     * LinkedList with all data of units.
     * <p>
     * All data is in format of LinkedTreeMap. It's using for creating units of HumanBeing class.
     * </p>
     */
    public static LinkedList<LinkedTreeMap<String, Object>> listOfData;

    /**
     * Linked list which contains units of HumanBeing class.
     */
    public static LinkedList<HumanBeing> listOfHumanBeing;

    /**
     * Date of initialization date of collection.
     */
    public static LocalDateTime dateOfInitialization;
    /**
     * Field for starting and ending program.
      */
    public static boolean ongoing = true;

    /**
     * Method for starting program.
     * @param args
     */
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
        UpdateCommand updateCommand = new UpdateCommand(consoleCommand);
        AddCommand addCommand = new AddCommand(consoleCommand);

        addCommand.execute(test);
        updateCommand.execute(test2);

        PrintAscendingCommand printAscendingCommand = new PrintAscendingCommand(consoleCommand);
        printAscendingCommand.execute();

        InfoCommand infoCommand = new InfoCommand(consoleCommand);
        infoCommand.execute();

        ShowCommand showCommand = new ShowCommand(consoleCommand);
        showCommand.execute();
    }

    /**
     * Makes list of HumanBeing units.
     * It takes LinkedList of LinkedTreeMap with all parameters of our unit.
     *
     * @author KruglovEgor
     * @param data LinkedList of LinkedTreeMap with all parameters of our unit.
     * @return LinkedList with units of HumanBeing units.
     */
    private static LinkedList<HumanBeing> makeListOfHumanBeing(LinkedList<LinkedTreeMap<String, Object>> data) {
        LinkedList<HumanBeing> listOfHumanBeing = new LinkedList<>();
        dateOfInitialization = java.time.LocalDateTime.now();
        for (LinkedTreeMap<String, Object> datum : data) {

            HumanBeing unit = new HumanBeing(LinkedTreeMapManager.getParams(datum));
            listOfHumanBeing.add(unit);
        }
        return listOfHumanBeing;}
}
