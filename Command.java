package Second_sem.lab5;

@FunctionalInterface
public interface Command {
    void execute(Object... param);
}
