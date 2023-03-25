package Second_sem.lab5.Kotlin

import Second_sem.lab5.BaseClasses.Car
import Second_sem.lab5.BaseClasses.Mood
import com.google.gson.internal.LinkedTreeMap
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDateTime

class Defaults {
    var example = HashMap<String, Any>()
    var ar_coord = ArrayList<Number>()
    var ar_date = IntArray(6)

    fun Defaults(txt: LinkedTreeMap<String, Any?>): LinkedTreeMap<String,Any?> {
        val id = WorkWithFile.readFromFile("Id.txt")
        val a = id.toDouble()
        txt["id"] = a
        ar_coord.add(0.0)
        ar_coord.add(0.0)
        ar_date[0] = LocalDateTime.now().year
        ar_date[1] = LocalDateTime.now().monthValue
        ar_date[2] = LocalDateTime.now().dayOfMonth
        ar_date[3] = LocalDateTime.now().hour
        ar_date[4] = LocalDateTime.now().minute
        ar_date[5] = LocalDateTime.now().second
        example["name"] = "Bob"
        example["coordinates"] = ar_coord
        example["creationDate"] = ar_date
        example["hasToothpick"] = false
        example["realHero"] = false
        example["impactSpeed"] = 100L
        example["soundtrackName"] = "Gan"
        example["minutesOfWaiting"] = 5.0
        example["mood"] = "LONGING"
        example["car"] = "GDV"
        for (key in example.keys) {
            if (txt[key] != example[key]) {
                txt.put(key,example.get(key))
            }
        }
        try {
            FileWriter("Id.txt").use { fileWriter -> fileWriter.write(java.lang.Double.toString((a + 1).toDouble())) }
        } catch (e: IOException) {
            throw RuntimeException(e)
        }
        return txt
    }
}
