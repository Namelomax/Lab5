package Second_sem.lab5.Kotlin.BaseClasses

class Coordinates (private val x: Double = 0.0, private val y: Float = 0.0F){
    override fun toString() : String{
        return "[$x; $y]"
    }
    constructor(list: List<Number>) :this(list[0] as Double, list[1].toFloat())
}