package Second_sem.lab5.Kotlin.BaseClasses

class Coordinates (private val x: Double = 0.0, private val y: Float = 0.0F){
    override fun toString() : String{
        return "[$x; $y]"
    }
    fun getCoordinates():List<Number>{
        return listOf(x, y)
    }
    constructor(list: List<Number?>?) :this(list?.get(0) as? Double ?: 0.0, (list?.get(1) as? Double ?: 0.0).toFloat())
}