package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.PrintingResults;

public class HelpCommand implements Command {

    private ConsoleCommand consoleCommand;

    public HelpCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        PrintingResults.printResults(consoleCommand.help());
    }
}
