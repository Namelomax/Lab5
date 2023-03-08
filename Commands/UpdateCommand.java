package Second_sem.lab5.Commands;

import Second_sem.lab5.Command;

public class UpdateCommand implements Command {

    private ConsoleCommand consoleCommand;
    public UpdateCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.add(param);
    }
}
