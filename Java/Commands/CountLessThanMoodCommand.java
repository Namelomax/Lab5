package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;
import Second_sem.lab5.Java.PrintingResults;

public class CountLessThanMoodCommand implements Command{

    private ConsoleCommand consoleCommand;

    public CountLessThanMoodCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {PrintingResults.printResults(consoleCommand.count_less_than_mood(param));}
}
