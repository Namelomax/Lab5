package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.Commands.*
import com.google.gson.internal.LinkedTreeMap
import java.util.*

class ConsoleRead {
    var commands = HashMap<String, Command>()
    var doubleParam = 0.0
    lateinit var command: String
    lateinit var line: String
    lateinit var parametr: Any
    lateinit var list: Array<Any?>
    lateinit var args: Array<String>
    var refactor = LinkedTreeMap<String, Any?>()


    fun CheckParam(txt: String) {
        if(txt.startsWith("{")){
            val txt = txt.replace("{", "").replace("}", "")
            val splittedcommand = txt.split(" ").dropLastWhile { it.isEmpty() }.toTypedArray() // Line со сканера
            args = splittedcommand.copyOfRange(1, splittedcommand.size)
            val df = Defaults()
            for (param in args) {
                val values = param.split("=");
                refactor[values[0]] = values[1].replace(",", "")
            }
            refactor=df.Defaults(refactor)
        }else if(!txt.isEmpty()){
            if(txt[0].isDigit()){
                doubleParam = txt[0].toDouble()
            }} else{line=txt}
    }
    fun Read(txt: String) {
        val splittedcommand = txt.split(" ")
        command = splittedcommand[0]
        CheckParam(splittedcommand.drop(1).joinToString(separator = ","))
    }

    fun CheckComand(command: String): Boolean {
        commands["add"] = AddCommand(refactor)
        commands["add_if_max"] = AddIfMaxCommand(refactor)
        commands["clear"] = ClearCommand()
        commands["count_by_minutes_of_waiting"] = CountByMinutesOfWaiting(doubleParam)
        commands["count_less_than_mood"] = CountLessThanMood(Second_sem.lab5.Kotlin.BaseClasses.Mood.LONGING)
        commands["help"] = HelpCommand()
        commands["exit"] = ExitCommand()
        commands["info"] = InfoCommand()
        commands["print_ascending"] = PrintAscending()
        commands["remove_by_id"] = RemoveByIdCommand(doubleParam)
        commands["remove_first"] = RemoveFirstCommand()
        commands["remove_head"] = RemoveHeadCommand()
        commands["save"] = SaveCommand()
        commands["show"] = ShowCommand()
        commands["update"] = UpdateCommand(refactor)
        return commands.containsKey(command)
    }
}