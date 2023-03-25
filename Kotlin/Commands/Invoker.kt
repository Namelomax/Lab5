package Second_sem.lab5.Kotlin.Commands

class Invoker {

    private var command: Command? = null

    fun setCommand(command: Command){
        this.command = command
    }

    fun executeCommand(){
        command?.execute()
    }
}