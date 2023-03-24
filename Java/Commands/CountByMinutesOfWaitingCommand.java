package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.PrintingResults;

public class CountByMinutesOfWaitingCommand implements Command{

    private ConsoleCommand consoleCommand;

    public CountByMinutesOfWaitingCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {PrintingResults.printResults(consoleCommand.count_by_minutes_of_waiting(param));}
}
