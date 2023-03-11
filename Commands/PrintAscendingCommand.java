package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;
import Second_sem.lab5.PrintingResults;

public class PrintAscendingCommand implements Command{

    private ConsoleCommand consoleCommand;

    public PrintAscendingCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        PrintingResults.printResults(consoleCommand.print_ascending());
    }
}
