package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;

public class AddIfMaxCommand implements Command{

    private ConsoleCommand consoleCommand;

    public AddIfMaxCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.add_if_max(param);
    }

}
