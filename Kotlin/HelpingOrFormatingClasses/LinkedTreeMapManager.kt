package Second_sem.lab5.Kotlin.HelpingOrFormatingClasses

import com.google.gson.internal.LinkedTreeMap

val fieldNames = listOf<String>("id", "name", "coordinates", "creationDate",
    "realHero", "hasToothpick", "impactSpeed", "soundtrackName",
    "minutesOfWaiting", "mood", "car")


fun makeLinkedTreeMap(params: List<Any?>) : LinkedTreeMap<String, Any?> {
    val linkedTreeMap = LinkedTreeMap<String, Any?>()
    for (i in fieldNames.indices){
        linkedTreeMap.put(fieldNames[i], params[i])
    }
    return linkedTreeMap
}

fun getPatams(linkedTreeMap: LinkedTreeMap<String, Any?>) : List<Any?>{
    val array = mutableListOf<Any?>(linkedTreeMap.size)
    for(i in 0 until linkedTreeMap.size){
        array[i] = linkedTreeMap.get(fieldNames[i])
    }
    return array
}