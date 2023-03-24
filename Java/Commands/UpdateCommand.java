package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.Exceptions.NoSuchIdException;
import Second_sem.lab5.Java.PrintingResults;

public class UpdateCommand implements Command {

    private ConsoleCommand consoleCommand;
    public UpdateCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        try {
            consoleCommand.update(param);
        }
        catch (NoSuchIdException e){
            PrintingResults.printResults(e.getMessage());
        }
    }
}
