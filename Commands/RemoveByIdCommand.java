package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class RemoveByIdCommand implements Command{

    private ConsoleCommand consoleCommand;

    public RemoveByIdCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.remove_by_id(param);
    }
}
