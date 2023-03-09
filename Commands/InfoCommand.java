package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class InfoCommand implements Command {
    private ConsoleCommand consoleCommand;

    public InfoCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.info();
    }
}
