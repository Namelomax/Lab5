package Second_sem.lab5;

import Second_sem.lab5.BaseClasses.Mood;
import Second_sem.lab5.Commands.*;
import com.google.gson.internal.LinkedTreeMap;

import java.util.Arrays;
import java.util.HashMap;

public class ConsoleRead {
     Object parametr;
    static HashMap<String, Command> commands = new HashMap<>();
    boolean iscorrect = false;
    Object[] list;
    String[] args;
    String command;
    Mood value;
    public Object[] Read(String txt){
        // use in main for commands ConsoleRead.commands.get(cr.Read(line)[0]).execute(Arrays.copyOfRange(cr.Read(line),1,cr.Read(line).length));
        LinkedTreeMap<String, Object> refactor = new LinkedTreeMap<>();
        txt =txt.replace("{", "").replace("}", "");
        String[] splittedcommand = txt.split(" ");  // Line со сканера
        command = splittedcommand[0];
        if(CheckComand(command)){
        args = Arrays.copyOfRange(splittedcommand, 1, splittedcommand.length);
        if (args.length >= 1 && args[0].contains("=")) {
            Defaults df = new Defaults();
            for (String param : args) {
                String[] values = param.split("=");
                values[1]=values[1].replace("," , "");
                refactor.put(values[0], values[1]);
            }
        parametr = df.Defaults(refactor);
        iscorrect=true;
            list = new Object[]{command,parametr};
        } else if (command.contains("mood")) {
            boolean contains = false;
            for (Mood mood : Mood.values()) {
                if (mood.name().equals(args[0].toUpperCase())) {
                    contains = true;
                    value= Mood.valueOf(args[0].toUpperCase());
                    break;
                }
            }if (!contains){System.out.println("No such mood");return null;}
            parametr = value;
            iscorrect=true;
            list = new Object[]{command,parametr};
        }else if (args.length == 1 && !args[0].contains("=")) {
            parametr = Double.parseDouble(args[0]);
            iscorrect=true;
            list = new Object[]{command,parametr};
        } else {
            parametr = null;
            list = new Object[]{command,parametr};
        }
 return list;} else {System.out.println("Команда не найдена"); return null;}
    }
    public Boolean CheckComand(String command){
        ConsoleCommand consoleCommand = new ConsoleCommand();
        commands.put("add",new AddCommand(consoleCommand));
        commands.put("add_if_max",new AddIfMaxCommand(consoleCommand));
        commands.put("clear",new ClearCommand(consoleCommand));
        commands.put("count_by_minutes_of_waiting",new CountByMinutesOfWaitingCommand(consoleCommand));
        commands.put("count_less_than_mood",new CountLessThanMoodCommand(consoleCommand));
        commands.put("help",new HelpCommand(consoleCommand));
        commands.put("exit",new ExitCommand(consoleCommand));
        commands.put("info", new InfoCommand(consoleCommand));
        commands.put("print_ascending",new PrintAscendingCommand(consoleCommand));
        commands.put("remove_by_id", new RemoveByIdCommand(consoleCommand));
        commands.put("remove_first", new RemoveFirstCommand(consoleCommand));
        commands.put("remove_head", new RemoveHeadCommand(consoleCommand));
        commands.put("save", new SaveCommand(consoleCommand));
        commands.put("show", new ShowCommand(consoleCommand));
        commands.put("update", new UpdateCommand(consoleCommand));
        if(!commands.containsKey(command)){ return false;}else {return true;}
    }

}
