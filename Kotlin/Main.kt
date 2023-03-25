package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.Commands.Invoker
import Second_sem.lab5.Kotlin.CommunicationWithUser.createFileId
import Second_sem.lab5.Kotlin.CommunicationWithUser.getPathToCollection
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.convertJSONtoLinkedList
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.printResults
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.readFromFile
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.writeInTxtFile
import com.google.gson.internal.LinkedTreeMap
import java.time.LocalDateTime
import java.util.*

var pathToCollection = ""
var pathToId = ".\\Id.txt"
var dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
    LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
    LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)
var listOfData = LinkedList<LinkedTreeMap<String, Any?>>()
var listOfHumanBeing = LinkedList<HumanBeing>()
var ongoing = true



fun main(){
    pathToCollection = getPathToCollection()
    //pathToCollection = "D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Data.json"
    createFileId()
    val data = readFromFile(pathToCollection)
    listOfData = convertJSONtoLinkedList(data)
    makeListOfHumanBeing()
    //println(listOfData)
    println(listOfHumanBeing)
    var consoleRead = ConsoleRead()
    var invoker = Invoker()
    while(ongoing){
        consoleRead.Read(readln())
        if(!consoleRead.CheckComand(consoleRead.command)){
            printResults("Wrong command")
            continue
        }

        consoleRead.commands.get(consoleRead.command)?.let { invoker.setCommand(it) }
        invoker.executeCommand()
    }
}

fun makeListOfHumanBeing() {
    dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
        LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
        LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)

    val maxId = listOfData.maxOf { it["id"] as Double? ?: 0.0 }
    writeInTxtFile(pathToId, (maxId+1).toString())

    fun getId() : Double{
        val currentMaxId = readFromFile(pathToId).toDouble()
        writeInTxtFile(pathToId, (currentMaxId+1).toString())
        return currentMaxId
    }

    val groupedById = listOfData.groupBy { it["id"] ?: getId()
    }
    println(groupedById)
    for(datum in groupedById){
        val unit = HumanBeing(datum.value[0])
        writeInTxtFile(pathToId, (java.lang.Double.max(unit.id.toDouble()+1, readFromFile(pathToId).toDouble() as Double? ?: 0.0)).toString())
        listOfHumanBeing.add(unit)
    }
}

//fun getSizeOfHumanBeingList() : Int = listOfHumanBeing.size