package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.convertJSONtoLinkedList
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.readFromFile
import com.google.gson.internal.LinkedTreeMap
import java.time.LocalDateTime
import java.util.*

public val path = ""
public var dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
    LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
    LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)
public var listOfData = LinkedList<LinkedTreeMap<String, Any?>>()
public var listOfHumanBeing = LinkedList<HumanBeing>()
public var ongoing = true



fun main(){
    val data = readFromFile(path)
    listOfData = convertJSONtoLinkedList(data)
    println(listOfData)
    listOfHumanBeing = makeListOfHumanBeing(listOfData)
    println(listOfHumanBeing)
}


fun makeListOfHumanBeing(data: LinkedList<LinkedTreeMap<String, Any?>>): LinkedList<HumanBeing> {
    val listOfHumanBeing = LinkedList<HumanBeing>()
    dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
        LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
        LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)

    for(datum: LinkedTreeMap<String, Any?> in data){
        val unit = HumanBeing(datum)
        listOfHumanBeing.add(unit)
    }
    return listOfHumanBeing
}

//fun getSizeOfHumanBeingList() : Int = listOfHumanBeing.size