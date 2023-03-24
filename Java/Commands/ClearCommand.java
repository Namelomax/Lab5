package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;

public class ClearCommand implements Command{
    private ConsoleCommand consoleCommand;

    public ClearCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.clear();
    }
}
