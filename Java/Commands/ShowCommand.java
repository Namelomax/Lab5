package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.PrintingResults;

public class ShowCommand implements Command {

    private final ConsoleCommand consoleCommand;

    public ShowCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        PrintingResults.printResults(consoleCommand.show());
    }
}
