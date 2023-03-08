package Second_sem.lab5.Commands;

import Second_sem.lab5.Command;

public class AddCommand implements Command {

    private ConsoleCommand consoleCommand;

    public AddCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.add(param);
    }
}
