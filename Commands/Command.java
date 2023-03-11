package Second_sem.lab5.Commands;

@FunctionalInterface
public interface Command {
    /**
     * Method for executing command.
     * @param param parameters for commands.
     * @author KruglovEgor
     */
    void execute(Object... param);
}
