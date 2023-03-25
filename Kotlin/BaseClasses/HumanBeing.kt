package Second_sem.lab5.Kotlin.BaseClasses

import Second_sem.lab5.Java.BaseClasses.HumanBeing
import com.google.gson.internal.LinkedTreeMap
import java.time.LocalDateTime

class HumanBeing(    val id: Int, val name: String="DefaultName", val coordinates: Coordinates = Coordinates(),
                     val creationDate: java.time.LocalDateTime = LocalDateTime.of(LocalDateTime.now().year,
                         LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
                         LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second),
                     val realHero: Boolean = false, val hasToothpick: Boolean = false, val impactSpeed: Long = 0,
                     val soundtrackName: String = "DefaultSoundtrackName", val minutesOfWaiting: Double? = null,
                     val mood: Mood? = null, val car: Car? = null) : Comparable<Second_sem.lab5.Kotlin.BaseClasses.HumanBeing>  {


//    val id: Int = 0
//    val name ="DefaultName"
//    val coordinates: Coordinates = Coordinates()
//    val creationDate: java.time.LocalDateTime = LocalDateTime.of(LocalDateTime.now().year,
//        LocalDateTime.now().monthValue, LocalDateTime.now().dayOfMonth,
//        LocalDateTime.now().hour, LocalDateTime.now().minute, LocalDateTime.now().second)
//    val realHero: Boolean = false
//    val hasToothpick: Boolean = false
//    val impactSpeed: Long = 0
//    val soundtrackName: String = "DefaultSoundtrackName"
//    val minutesOfWaiting: Double? = null
//    val mood: Mood? = null
//    val car: Car? = null


    constructor(linkedTreeMap: LinkedTreeMap<String, Any?>) :this(
        //TODO fix id
        (linkedTreeMap["id"] as? Double ?: Math.rint(4214.4)).toInt(), linkedTreeMap["name"] as? String ?: "DefaultName",
        Coordinates(linkedTreeMap["coordinates"] as? List<Number> ?: listOf(0.0, 0.0F)),
        makeLocalDateTime(linkedTreeMap["creationDate"] as? List<Int> ?:
        listOf(LocalDateTime.now().year, LocalDateTime.now().monthValue,
            LocalDateTime.now().dayOfMonth, LocalDateTime.now().hour,
            LocalDateTime.now().minute, LocalDateTime.now().second)),
        linkedTreeMap["realHero"] as? Boolean ?: false,
        linkedTreeMap["hasToothpick"] as? Boolean ?: false,
        (linkedTreeMap["impactSpeed"] as? Double ?: 0.0).toLong(),
        linkedTreeMap["soundtrackName"] as? String ?: "DefaultSoundtrackName",
        linkedTreeMap["minutesOfWaiting"] as? Double? ?: null,
        (linkedTreeMap["mood"] as? String? ?: null)?.let { Mood.valueOf(it) },
        Car(linkedTreeMap["car"] as? String? ?: null))

    override fun compareTo(other: Second_sem.lab5.Kotlin.BaseClasses.HumanBeing): Int {
        return id.compareTo(other.id)
    }


    override fun toString(): String {
        return """
            
            id: $id
            name: $name
            coordinates: $coordinates
            creation date: $creationDate
            real hero: $realHero
            has toothpick: $hasToothpick
            impact speed: $impactSpeed
            soundtrack name: $soundtrackName
            minutes of waiting: $minutesOfWaiting
            mood: $mood
            car: $car
            """.trimIndent()
    }


}