package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.convertJSONtoLinkedList
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.readFromFile
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.writeInTxtFile
import com.google.gson.internal.LinkedTreeMap
import java.time.LocalDateTime
import java.util.*

public var pathToCollection = ""
public var pathToId = ""
public var dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
    LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
    LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)
public var listOfData = LinkedList<LinkedTreeMap<String, Any?>>()
public var listOfHumanBeing = LinkedList<HumanBeing>()
public var ongoing = true



fun main(){
    pathToCollection = "D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Data.json"
    pathToId = "D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Id.txt"
    val data = readFromFile(pathToCollection)
    listOfData = convertJSONtoLinkedList(data)
    makeListOfHumanBeing()
    println(listOfHumanBeing)
}


fun makeListOfHumanBeing() {
    dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
        LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
        LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)

    val maxId = listOfData.maxOf { it["id"] as Double? ?: 0.0 }
    writeInTxtFile(pathToId, (maxId+1).toString())
    val grouprdById = listOfData.groupBy { it["id"] ?: {
        val currentMaxId = readFromFile(pathToId).toDouble()
        writeInTxtFile(pathToId, (currentMaxId+1).toString())
        currentMaxId
    }

    }

    for(datum in grouprdById){
        val unit = HumanBeing(datum.value[0])
        writeInTxtFile(pathToId, (java.lang.Double.max(unit.id.toDouble()+1, readFromFile(pathToId).toDouble() as Double? ?: 0.0)).toString())
        listOfHumanBeing.add(unit)
    }
}

//fun getSizeOfHumanBeingList() : Int = listOfHumanBeing.size