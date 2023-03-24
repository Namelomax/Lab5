package Second_sem.lab5.Kotlin

import Second_sem.lab5.Kotlin.BaseClasses.HumanBeing
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.convertJSONtoLinkedList
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.getPatams
import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.readFromFile
import com.google.gson.internal.LinkedTreeMap
import java.time.LocalDateTime
import java.util.*

val path = "D:\\Intelij IDEA projects\\untitled\\src\\Second_sem\\lab5\\Data.json"
var dateOfInitialization = LocalDateTime.of(LocalDateTime.now().year,
    LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
    LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)



fun main(){
    val data = readFromFile(path)
    var listOfData: LinkedList<LinkedTreeMap<kotlin.String, Any?>> = convertJSONtoLinkedList(data)
    println(listOfData)
    var listOfHumanBeing: LinkedList<HumanBeing>
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