package Second_sem.lab5.Kotlin

import Second_sem.lab5.BaseClasses.Mood
import Second_sem.lab5.Kotlin.Commands.*
import com.google.gson.internal.LinkedTreeMap
import java.util.*

class ConsoleRead {
    var commands = HashMap<String, Command>()
    var doubleparam = 0.0
    lateinit var command: String
    lateinit var line: String
    lateinit var parametr: Any
    lateinit var list: Array<Any?>
    lateinit var args: Array<String>
    var refactor = LinkedTreeMap<String, Any?>()
    fun CheckParam(txt: String) {
        if (txt.startsWith("{")) {
            val txt = txt.replace("{", "").replace("}", "")
            val splittedcommand = txt.split(" ")
            val df = Defaults()
            for (param in splittedcommand) {
                val values = param.split("=")
                refactor[values[0]] = values[1].replace(",", "")
            }
            //  refactor= df.Defaults(refactor)
        } else if (!txt.isEmpty()) {
            if (txt[0].isDigit()) {
                doubleparam = txt[0].toString().toDouble()
            }
        } else {
            line = txt
        }
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
        commands["count_by_minutes_of_waiting"] = CountByMinutesOfWaiting(doubleparam)
        commands["count_less_than_mood"] = CountLessThanMood(Second_sem.lab5.Kotlin.BaseClasses.Mood.LONGING)
        commands["help"] = HelpCommand()
        commands["exit"] = ExitCommand()
        commands["info"] = InfoCommand()
        commands["print_ascending"] = PrintAscending()
        commands["remove_by_id"] = RemoveByIdCommand(doubleparam)
        commands["remove_first"] = RemoveFirstCommand()
        commands["remove_head"] = RemoveHeadCommand()
        commands["save"] = SaveCommand()
        commands["show"] = ShowCommand()
        commands["update"] = UpdateCommand(refactor)

        if (commands.containsKey(command)) {
            return true
        } else {
            println("Команда не найдена")
            return false
        }
    }

    fun fillCollection() {
        var toothPickCheck: Boolean = true
        var realHeroCheck: Boolean = true
        var soundtrackCheck: Boolean = true
        var minutesCheck: Boolean = true
        var moodCheck: Boolean = true
        var carCheck: Boolean = true
        var xcoordinateCheck: Boolean = true
        var ycoordinateCheck: Boolean = true
        var nameCheck: Boolean = true
        var speedCheck: Boolean = true
        val ar_coord = ArrayList<Number>()
            println("Enter name")
        while (nameCheck){
            val line =readln().trim()
            if (line.matches(Regex("-?\\d+(\\.\\d+)?"))&& line!="") {
                println("Please enter a non-numeric value.")
                continue
            }else{refactor["name"] = line
                nameCheck=false
            }}
            println("Enter X-axis coordinates")
        while (xcoordinateCheck){
            val coordline =readln().trim()
            if (coordline.toDoubleOrNull() == null) {
                println("Please enter number.")
                continue
            }
            else{ val x: Number = coordline.toDouble()
            ar_coord.add(x)
                xcoordinateCheck=false
            }}

            println("Enter Y-axis coordinates")
        while (ycoordinateCheck){
            val coordline =readln().trim()
            if (coordline.toDoubleOrNull() == null) {
                println("Please enter number.")
                continue
            }
            else{
                val y: Number = coordline.toDouble()
                ar_coord.add(y)
                ycoordinateCheck=false
            }}
        refactor["coordinates"] = ar_coord
        println("Has toothPick? (yes/no)")
        while (toothPickCheck){
            val line =readln().trim()
        if (line=="yes"){
            refactor["hasToothpick"] = true
        toothPickCheck=false
        }
        else if (line=="no"){refactor["hasToothpick"] = false
            toothPickCheck=false}
        else{
            println("should be yes or no")
            continue
        } }
        println("Is real hero? (yes/no)")
        while (realHeroCheck){
            val line =readln().trim()
            if (line=="yes"){
                refactor["realHero"] = true
                realHeroCheck=false
            }
            else if (line=="no"){refactor["realHero"] = false
                realHeroCheck=false}
            else{
                println("should be yes or no")
                continue
            } }
            println("Enter impactspeed")
        while (speedCheck){
            val line =readln().trim()
            if (line.toLongOrNull() == null) {
                println("Please enter a valid number.")
                continue
            } else{refactor["minutesOfWaiting"] = line.toLong()
                speedCheck=false
            }}
            println("Enter soundtrackName")
        while (soundtrackCheck){
            val line =readln().trim()
        if (line.matches(Regex("-?\\d+(\\.\\d+)?")) && line!="") {
            println("Please enter a non-numeric value.")
            continue
        }else{refactor["soundtrackName"] = line
            soundtrackCheck=false
        }}
        println("Enter minutesOfWaiting")
        while (minutesCheck){
            val line =readln().trim()
            if (line.toDoubleOrNull() == null) {
                println("Please enter a double number.")
                continue
            } else{refactor["minutesOfWaiting"] = line.toDouble()
                minutesCheck=false
            }}
        println("Enter mood")
        while (moodCheck) {
            val line =readln().trim()
            for (mood in Mood.values()) {
                if (mood.name == line.uppercase()) {
                    moodCheck = false
                    refactor["mood"] = line.uppercase()
                    break
                }
            }
            if (moodCheck) {
                println("No such mood")
                continue
            }
        }
        println("Enter car")
        while (carCheck){
            val line =readln().trim()
            if (line.matches(Regex("-?\\d+(\\.\\d+)?")) && line!="") {
                println("Please enter a non-numeric value.")
                continue
            }else{refactor["car"] = line
                carCheck=false
            }}
        }
}