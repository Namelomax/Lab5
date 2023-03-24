package Second_sem.lab5.Kotlin.BaseClasses

class Car(val name: String? = null) {
    override fun toString(): String
    {
        return name.toString()
    }
}