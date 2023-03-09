package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class RemoveFirstCommand implements Command{

    private ConsoleCommand consoleCommand;

    public RemoveFirstCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.remove_first();
    }
}
