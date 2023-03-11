package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;
import Second_sem.lab5.PrintingResults;

public class ShowCommand implements Command {

    private final ConsoleCommand consoleCommand;

    public ShowCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        PrintingResults.printResults(consoleCommand.show());
    }
}
