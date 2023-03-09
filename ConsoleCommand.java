package Second_sem.lab5;

import Second_sem.lab5.LinkedTreeMapCommander;
import Second_sem.lab5.BaseClasses.HumanBeing;
import Second_sem.lab5.Main;
import com.google.gson.internal.LinkedTreeMap;

import java.io.Console;
import java.util.Collections;

public class ConsoleCommand {
    public void help(){
        System.out.println("help : вывести справку по доступным командам\n" +
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
                "print_ascending : вывести элементы коллекции в порядке возрастания");
    }

    public void info(){
        System.out.println(Main.listOfData);
    }

    public void show(){
        for(HumanBeing person: Main.listOfHumanBeing){
            System.out.println(person);
        }
    }

    public void add(Object... parametres){
        Main.listOfData.add(LinkedTreeMapCommander.makeLinkedTreeMap(parametres));
        Main.listOfHumanBeing.add(new HumanBeing(parametres));
    }

    public void update(Object... parametres){
        remove_by_id(parametres[0]);
        add(parametres);
    }

    public void remove_by_id(Object... parametres){
        for(LinkedTreeMap set_of_data: Main.listOfData){
            if (set_of_data.get("id").equals(parametres[0])){
                Main.listOfData.remove(set_of_data);
                break;
            }
        }
        for(HumanBeing unit: Main.listOfHumanBeing){
            if(unit.getId().equals(parametres[0])){
                Main.listOfHumanBeing.remove(unit);
                break;
            }
        }
    }

    public void clear(){
        Main.listOfData.clear();
        Main.listOfHumanBeing.clear();
    }

    public void save(){
        WorkWithFile.writeInFile(Main.path, Main.listOfData);
    }

    //@TODO execute_script

    public void exit(){
        exit();
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

    public void add_if_max(Object... parametres){
        Collections.sort(Main.listOfHumanBeing);
        if(Main.listOfHumanBeing.getLast().getId() < (Double) parametres[0]){
            add(parametres);
        }
    }

    public void count_by_minutes_of_waiting(Object... parametres){
        int count = 0;
        for(HumanBeing unit: Main.listOfHumanBeing){
            if(unit.getMinutesOfWaiting().equals(parametres[0])){count++;}
        }
        System.out.println(count);
    }


    
}
