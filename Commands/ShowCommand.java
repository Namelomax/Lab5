package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class ShowCommand implements Command {

    private final ConsoleCommand consoleCommand;

    public ShowCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.show();
    }
}
