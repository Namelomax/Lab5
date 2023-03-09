package Second_sem.lab5.Commands;

import Second_sem.lab5.ConsoleCommand;

public class SaveCommand implements Command{

    private ConsoleCommand consoleCommand;

    public SaveCommand(ConsoleCommand consoleCommand){this.consoleCommand=consoleCommand;}
    @Override
    public void execute(Object... param) {
        consoleCommand.save();
    }

}
