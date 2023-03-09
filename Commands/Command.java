package Second_sem.lab5.Commands;

@FunctionalInterface
public interface Command {
    void execute(Object... param);
}
