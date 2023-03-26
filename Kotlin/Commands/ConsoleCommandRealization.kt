package Second_sem.lab5.Kotlin.Commands

import Second_sem.lab5.Kotlin.*
import Second_sem.lab5.Kotlin.BaseClasses.*
import Second_sem.lab5.Kotlin.Exceptions.IdIsOccupiedException
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.*
import com.google.gson.internal.LinkedTreeMap
import java.lang.Double.max
import java.util.*


class HelpCommand() : Command{
    fun getHelp():String{
        val txt = """
            help : вывести справку по доступным командам
            info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
            show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
            add {element} : добавить новый элемент в коллекцию
            update id {element} : обновить значение элемента коллекции, id которого равен заданному
            remove_by_id id : удалить элемент из коллекции по его id
            clear : очистить коллекцию
            save : сохранить коллекцию в файл
            execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
            exit : завершить программу (без сохранения в файл)
            remove_first : удалить первый элемент из коллекции
            remove_head : вывести первый элемент коллекции и удалить его
            add_if_max {element} : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
            count_by_minutes_of_waiting minutesOfWaiting : вывести количество элементов, значение поля minutesOfWaiting которых равно заданному
            count_less_than_mood mood : вывести количество элементов, значение поля mood которых меньше заданного
            print_ascending : вывести элементы коллекции в порядке возрастания
            """.trimIndent();
        return txt
    }

    override fun execute() {
        printResults(getHelp())
    }
}


class InfoCommand():Command{
    fun getInfo():String{
        val txt = """
            Class of collection: LinkedList
            Count of units: ${listOfHumanBeing.size}}
            Date of initialization: ${dateOfInitialization}
            """.trimIndent()
        return txt
    }

    override fun execute() {
        printResults(getInfo())
    }
}


class ShowCommand : Command{
    var txt: String =""
    private fun getShow():String{
        txt = listOfHumanBeing.toString()
        return txt
    }

    override fun execute() {
        printResults(getShow())
    }

}


class AddCommand(val mapWithParams: LinkedTreeMap<String, Any?>) : Command{

    constructor(list: List<Any?>): this(makeLinkedTreeMap(list))

    fun checkIfIdIsOccupied(): Boolean{
        var occupied = false
        for(unit in listOfHumanBeing){
            if(unit.id.equals((mapWithParams["id"] as Double?)?.toInt())){
                occupied = true
                break
            }
        }
        return occupied
    }

    override fun execute() {
        if (checkIfIdIsOccupied()){
            throw IdIsOccupiedException("Sorry, but this id is already occupied.")
        }
        val unit = HumanBeing(mapWithParams)
        writeInTxtFile(pathToId, (max((mapWithParams["id"] as Double?  ?: -1.0)+1, readFromFile(pathToId).toDouble() as Double? ?: 0.0)+1).toString())
        listOfData.add(unit.makeLinkedTreeMap())
        listOfHumanBeing.add(unit)
    }

}

class UpdateCommand(val id:Int, val mapWithParams: LinkedTreeMap<String, Any?>) : Command{
    constructor(id: Int, list: List<Any?>): this(id, makeLinkedTreeMap(list))
   constructor(id: Double, map: LinkedTreeMap<String, Any?>): this(id.toInt(), map)
    //constructor(id: Double, map: LinkedTreeMap<String, Any?>): this(id.toInt(), map)

    fun  checkIfIdExists() :Boolean{
        for(unit : HumanBeing in listOfHumanBeing){
            println(id)
            println(unit.id)
            if(unit.id.equals(id)) {
                return true
            }
        }
        return false
    }

    override fun execute() {
        if (checkIfIdExists()){
            for (unit : HumanBeing in listOfHumanBeing){
                if(unit.id.equals(id)){
                    val newUnit = HumanBeing(id, name = mapWithParams["name"] as? String ?: unit.name,
                        coordinates = Coordinates(mapWithParams["coordinates"] as? List<Number> ?: unit.coordinates.getCoordinates()),
                        creationDate = (mapWithParams["creationDate"] as? List<Int>)?.let { makeLocalDateTime(it) } ?: unit.creationDate,
                        realHero = mapWithParams["realHero"] as? Boolean ?: unit.realHero,
                        hasToothpick = mapWithParams["hasToothpick"] as? Boolean ?: unit.hasToothpick,
                        impactSpeed = (mapWithParams["impactSpeed"] as? Double)?.toLong() ?: unit.impactSpeed,
                        soundtrackName = mapWithParams["soundtrackName"] as? String ?: unit.soundtrackName,
                        minutesOfWaiting = mapWithParams["minutesOfWaiting"] as? Double ?: unit.minutesOfWaiting,
                        mood = (mapWithParams["mood"] as? String ?: unit.mood.toString()).let { Mood.valueOf(it) },
                        car = Car(mapWithParams["car"] as? String ?: unit.car.toString())
                    )
                    listOfHumanBeing.add(newUnit)
                    listOfHumanBeing.remove(unit)
                    break
                }
            }
        } else println("There is no unit with such id. Please, try to write another id.")
    }

}


class RemoveByIdCommand(val id: Double):Command{

    constructor(id: Int): this(id.toDouble())

    fun  checkIfIdExists() :Boolean{
        for(unit : HumanBeing in listOfHumanBeing){
            if(unit.id.equals(id.toInt())) {
                listOfHumanBeing.remove(unit)
                return true
            }
        }
        return false
    }

    override fun execute() {
        if (checkIfIdExists()){
            for(map in listOfData){
                if((map["id"] as Double).equals(id)){
                    listOfData.remove(map)
                    break
                }
            }
        }
        else println("There is no unit with such id. Please, try to write another id.")
    }

}


class ClearCommand():Command{
    override fun execute() {
        listOfData.clear()
        listOfHumanBeing.clear()
    }

}


class SaveCommand() : Command{
    override fun execute() {
        val list = LinkedList<LinkedTreeMap<String, Any?>>()
        for (unit in listOfHumanBeing){
            list.add(unit.makeLinkedTreeMap())
        }
        writeInJSONFile(pathToCollection, list)
    }
}


//TODO executeScriptCommand



class ExitCommand(): Command{
    override fun execute() {
        ongoing = false
    }
}


class RemoveFirstCommand():Command{
    override fun execute() {
        listOfHumanBeing.sort()
        val removeById = RemoveByIdCommand(listOfHumanBeing[0].id.toDouble())
        removeById.execute()
    }
}


class RemoveHeadCommand():Command{
    override fun execute() {
        listOfHumanBeing.sort()
        val removeById = RemoveByIdCommand(listOfHumanBeing[0].id.toDouble())
        if (listOfHumanBeing.size > 0) printResults(listOfHumanBeing[0])
        removeById.execute()
    }
}

//TODO check logic
class AddIfMaxCommand(val mapWithParams: LinkedTreeMap<String, Any?>) : Command {

    constructor(list: List<Any?>) : this(makeLinkedTreeMap(list))

    override fun execute() {
        listOfHumanBeing.sort()
        println(listOfHumanBeing.last.id)
        println((mapWithParams["id"].toString().toIntOrNull()?:readFromFile(pathToId).toInt()))
        if(listOfHumanBeing.last.id < (mapWithParams["id"].toString().toIntOrNull()?:readFromFile(pathToId).toDouble()).toInt()){
            val add = AddCommand(mapWithParams)
            add.execute()
        }
    }
}


class CountByMinutesOfWaiting(val minutesOfWaiting: Double) : Command{
    fun getCountByMinutesOfWaiting() : Int{
        var count = 0
        for(unit in listOfHumanBeing){
            if(unit.minutesOfWaiting?.equals(minutesOfWaiting) == true){
                count++
            }
        }
        return count
    }
    override fun execute() {
        printResults(getCountByMinutesOfWaiting())
    }

}


class CountLessThanMood(val mood: Mood):Command{

    constructor(moodStr : String) : this(Mood.valueOf(moodStr))

    fun getCountLessThanMood():Int{
        var count = 0
        for (unit in listOfHumanBeing){
            if(unit.mood != null){
                if(unit.mood!!.compareTo(mood) < 0){
                    count++
                }
            }
        }
        return count
    }

    override fun execute() {
        printResults(getCountLessThanMood())
    }
}


class PrintAscending() : Command{
    override fun execute() {
        listOfHumanBeing.sort()
        printResults(listOfHumanBeing)
    }
}