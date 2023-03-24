package Second_sem.lab5.Kotlin.HelpingOrFormatingClasses

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.internal.LinkedTreeMap
import java.io.*
import java.util.*


fun readFromFile(pathToFile: String): String {
    var txt = ""
    try {
        txt = Scanner( File(pathToFile)).useDelimiter("\\Z").next()
    } catch (e: FileNotFoundException) {
        //todo add print by class
        println("File not found")
    }
    return txt
}


fun convertJSONtoLinkedList(txt: String) : LinkedList<LinkedTreeMap<String, Any?>> {
    return Gson().fromJson(txt, LinkedList::class.java) as LinkedList<LinkedTreeMap<String, Any?>>
}


fun writeInJSONFile(pathToFile: String, data: LinkedList<*>) {
    val gson = GsonBuilder().serializeNulls().setPrettyPrinting().create()
    val jsonString = gson.toJson(data)
    try  {
       val bos = BufferedOutputStream(FileOutputStream(pathToFile))
        bos.write(jsonString.toByteArray())
    }
    catch (e: IOException){
        throw IOException(e)
    }
    catch (e: RuntimeException){
        throw RuntimeException(e)
    }
}


fun writeInTxtFile(pathToFile: String, data: String){
    try {
        val fileWriter = FileWriter(pathToFile)
        fileWriter.write(data)
        fileWriter.flush()
        fileWriter.close()
    }
    catch (e: IOException){
        throw IOException(e)
    }
}