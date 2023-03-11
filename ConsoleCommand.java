package Second_sem.lab5;

import Second_sem.lab5.BaseClasses.Mood;
import Second_sem.lab5.BaseClasses.HumanBeing;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Collections;

public class ConsoleCommand {

    /**
     * Printing list of command with their description
     * @author KruglovEgor
     */
    public String help(){
        String txt = "help : вывести справку по доступным командам\n" +
                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                "add {element} : добавить новый элемент в коллекцию\n" +
                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                "remove_by_id id : удалить элемент из коллекции по его id\n" +
                "clear : очистить коллекцию\n" +
                "save : сохранить коллекцию в файл\n" +
                "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                "exit : завершить программу (без сохранения в файл)\n" +
                "remove_first : удалить первый элемент из коллекции\n" +
                "remove_head : вывести первый элемент коллекции и удалить его\n" +
                "add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции\n" +
                "count_by_minutes_of_waiting minutesOfWaiting : вывести количество элементов, значение поля minutesOfWaiting которых равно заданному\n" +
                "count_less_than_mood mood : вывести количество элементов, значение поля mood которых меньше заданного\n" +
                "print_ascending : вывести элементы коллекции в порядке возрастания";
        return txt;
    }

    /**
     * Printing class, size and date of initialization of collection
     * @author KruglovEgor
     */
    public String info(){
        String txt = "Class of collection: "+Main.listOfHumanBeing.getClass() +
                "\n"+"Count of units: "+Main.listOfHumanBeing.size()+
                "\n"+"Date of initialization: "+Main.dateOfInitialization+"\n";
        return txt;
    }

    /**
     * Printing all units in collection
     * @author KruglovEgor
     */
    public String show(){
        String txt = Main.listOfHumanBeing.toString();
        return txt;
    }

    /**
     * Add new unit in collection.
     * @param parameters all parameters of HumanBeing's unit without their names in order like in HumanBeing
     * @author KruglovEgor
     */
    public void add(Object... parameters){
        Main.listOfData.add(LinkedTreeMapManager.makeLinkedTreeMap(parameters));
        Main.listOfHumanBeing.add(new HumanBeing(parameters));
    }

    /**
     * Change parameters of HumanBeing unit.
     * @param parameters id of unit
     * @author KruglovEgor
     */
    public void update(Object... parameters){
        remove_by_id(parameters[0]);
        add(parameters);
    }

    /**
     * Remove HumanBeing unit by its id.
     * @param parameters id of unit
     * @author KruglovEgor
     */
    public void remove_by_id(Object... parameters){
        for(LinkedTreeMap set_of_data: Main.listOfData){
            if (set_of_data.get("id").equals(parameters[0])){
                Main.listOfData.remove(set_of_data);
                break;
            }
        }
        for(HumanBeing unit: Main.listOfHumanBeing){
            if(unit.getId().equals(parameters[0])){
                Main.listOfHumanBeing.remove(unit);
                break;
            }
        }
    }

    /**
     * Remove all units from collection.
     * @author KruglovEgor
     */
    public void clear(){
        Main.listOfData.clear();
        Main.listOfHumanBeing.clear();
    }

    /**
     * Save all units in json file (path to it was given by user in the beginning).
     * @author KruglovEgor
     */
    public void save(){
        WorkWithFile.writeInFile(Main.path, Main.listOfData);
    }

    //@TODO execute_script

    /**
     * Exit from program.
     * @author KruglovEgor
     */
    public void exit(){
        Main.ongoing = false;
    }

    public void remove_first(){
        Collections.sort(Main.listOfHumanBeing);
        remove_by_id(Main.listOfHumanBeing.getFirst().getId());
    }

    public void remove_head(){
        Collections.sort(Main.listOfHumanBeing);
        System.out.println(Main.listOfHumanBeing.getFirst());
        remove_by_id(Main.listOfHumanBeing.getFirst().getId());
    }

    public void add_if_max(Object... parameters){
        Collections.sort(Main.listOfHumanBeing);
        if(Main.listOfHumanBeing.getLast().getId() < (Double) parameters[0]){
            add(parameters);
        }
    }

    public void count_by_minutes_of_waiting(Object... parameters){
        int count = 0;
        for(HumanBeing unit: Main.listOfHumanBeing){
            if(unit.getMinutesOfWaiting().equals(parameters[0])){count++;}
        }
        System.out.println(count);
    }

    public void count_less_than_mood(Object... parameters){
        int count = 0;
        for(HumanBeing unit: Main.listOfHumanBeing){
            if(unit.getMood().compareTo((Mood) parameters[0]) < 0){count++;}
        }
        System.out.println(count);
    }

    public void print_ascending(){
        Collections.sort(Main.listOfHumanBeing);
        for(HumanBeing unit: Main.listOfHumanBeing){
            System.out.println(unit+"\n");
        }
    }
}
