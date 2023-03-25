package Second_sem.lab5.Kotlin.CommunicationWithUser

import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.printResults
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path


fun getPathToCollection() : String{
    printResults("Please enter the absolute path to the file.json with collection: ")
    var usersPath = Path(readln())
    while (Files.notExists(usersPath) or (File(usersPath.toString()).extension != "json") or (!Files.isReadable(usersPath))){
        printResults("It's a wrong file. Please enter another path:")
        usersPath = Path(readln())
    }
    return usersPath.toString()
}


fun createFileId(){
    val fileName = "Id.txt"
    val file = File(fileName)
    file.createNewFile()
}