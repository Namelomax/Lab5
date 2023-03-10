package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class ExitCommand implements Command{

    private ConsoleCommand consoleCommand;

    public ExitCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.exit();
    }
}
