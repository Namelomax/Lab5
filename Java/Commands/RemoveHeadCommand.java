package Second_sem.lab5.Java.Commands;

import Second_sem.lab5.Java.ConsoleCommand;

public class RemoveHeadCommand implements Command{

    private ConsoleCommand consoleCommand;

    public RemoveHeadCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.remove_head();
    }
}

