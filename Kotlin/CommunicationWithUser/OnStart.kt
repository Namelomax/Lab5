package Second_sem.lab5.Kotlin.CommunicationWithUser

import Second_sem.lab5.Kotlin.HelpingOrFormatingClasses.printResults
import java.io.File
import java.nio.file.Files
import kotlin.io.path.Path


fun getPathToCollection() : String{
    printResults("Please enter the absolute path to the file.json with collection: ")
    //var usersPath = Path(readln())
    //var usersPath = Path(readln())
    var usersPath = readln().trim()
    var file = File(usersPath)
    while (!file.exists() or (file.extension != "json")){
        printResults("It's a wrong file. Please enter another path:")
        usersPath = readln().trim()
        file = File(usersPath)
    }
    printResults("Successful!")
    return usersPath
}


fun createFileId(){
    val fileName = "Id.txt"
    val file = File(fileName)
    file.createNewFile()
}