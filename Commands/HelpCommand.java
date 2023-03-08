package Second_sem.lab5.Commands;

import Second_sem.lab5.Command;

public class HelpCommand implements Command {

    private ConsoleCommand consoleCommand;

    public HelpCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.help();
    }
}
