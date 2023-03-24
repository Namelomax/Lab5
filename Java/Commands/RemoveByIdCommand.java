package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.Exceptions.NoSuchIdException;
import Second_sem.lab5.Java.PrintingResults;

public class RemoveByIdCommand implements Command{

    private ConsoleCommand consoleCommand;

    public RemoveByIdCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        try {
            consoleCommand.remove_by_id(param);
        }
        catch (NoSuchIdException e){
            PrintingResults.printResults(e.getMessage());
        }
    }
}
