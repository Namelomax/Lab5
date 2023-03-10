package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class CountLessThanMoodCommand implements Command{

    private ConsoleCommand consoleCommand;

    public CountLessThanMoodCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.count_less_than_mood(param);
    }
}
