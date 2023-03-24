package Second_sem.lab5.Kotlin.Commands

import Second_sem.lab5.Kotlin.*
import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.makeLinkedTreeMap
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.printResults
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.writeInJSONFile
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.writeInTxtFile
import com.google.gson.internal.LinkedTreeMap

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
    fun getShow():String{
        val txt = listOfHumanBeing.toString()
        return txt
    }

    override fun execute() {
        printResults(getShow())
    }

}


class AddCommand(val mapWithParams: LinkedTreeMap<String, Any?>) : Command{

    constructor(list: List<Any?>): this(makeLinkedTreeMap(list))

    override fun execute() {
        listOfData.add(mapWithParams)
        val unit = HumanBeing(mapWithParams)
        listOfHumanBeing.add(unit)
        writeInTxtFile("D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Id.txt", unit.id.toString())
    }

}


class UpdateCommand(val mapWithParams: LinkedTreeMap<String, Any?>) : Command{

    constructor(list: List<Any?>): this(makeLinkedTreeMap(list))

    override fun execute() {
        val removeById = RemoveByIdCommand(mapWithParams["id"] as Double)
        removeById.execute()
        val add = AddCommand(mapWithParams)
        add.execute()
    }

}


class RemoveByIdCommand(val id: Int):Command{

    constructor(id: Double): this(id.toInt())

    val idExists = checkIfIdExists()

    fun  checkIfIdExists() :Boolean{
        for(unit : HumanBeing in listOfHumanBeing){
            if(unit.id.equals(id)) {
                listOfHumanBeing.remove(unit)
                return true
            }
        }
        return false
    }

    override fun execute() {
        if (idExists){
            for(map in listOfData){
                if((map["id"] as Double).toInt().equals(id)){
                    listOfData.remove(map)
                    break
                }
            }
        }
        //TODO make exception
        //else throw new NoSuchIdException("There is no unit with such id. Please, try to write another id.")
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
        writeInJSONFile(path, listOfData)
    }
}


