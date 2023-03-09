package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class CountByMinutesOfWaitingCommand implements Command{

    private ConsoleCommand consoleCommand;

    public CountByMinutesOfWaitingCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.count_by_minutes_of_waiting(param);
    }
}
