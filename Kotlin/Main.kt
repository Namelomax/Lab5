package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.Commands.*
import Second_sem.lab5.Kotlin.CommunicationWithUser.createFileId
import Second_sem.lab5.Kotlin.CommunicationWithUser.getPathToCollection
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.convertJSONtoLinkedList
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
var commands = HashMap<String, Command>()


fun main(){
    val cr = ConsoleRead()
    pathToCollection = getPathToCollection()
    createFileId()
    val invoker = Invoker()
    val data = readFromFile(pathToCollection)
    listOfData = convertJSONtoLinkedList(data)
    makeListOfHumanBeing()
    while (ongoing){
        println("Введите команду")
        cr.Read(readln().trim())
        if(!cr.CheckComand(cr.command)){continue}
        invoker.setCommand(cr.commands[cr.command])
        invoker.executeCommand()
    }
}
fun makeListOfHumanBeing() {
    dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
        LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
        LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)

    val maxId = listOfData.maxOf { it["id"] as Double? ?: 0.0 }
    writeInTxtFile(pathToId, (maxId+1).toString())
    val groupedById = listOfData.groupBy { it["id"] ?: {
        val currentMaxId = readFromFile(pathToId).toDouble()
        writeInTxtFile(pathToId, (currentMaxId+1).toString())
        currentMaxId
    }
    }

    for(datum in groupedById){
        val unit = HumanBeing(datum.value[0])
        writeInTxtFile(pathToId, (java.lang.Double.max(unit.id.toDouble()+1, readFromFile(pathToId).toDouble() as Double? ?: 0.0)).toString())
        listOfHumanBeing.add(unit)
    }
}

//fun getSizeOfHumanBeingList() : Int = listOfHumanBeing.size