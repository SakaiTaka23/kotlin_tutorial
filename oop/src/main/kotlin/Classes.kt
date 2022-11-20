class Car(name: String, var model: String, var color: String, var doors: Int) {
    var name = name.trim()

    fun move() {
        println("The car $name is moving")
    }

    fun stop() {
        println("The car has stopped")
    }
}

class Calculator() {
    companion object {
        var max = 10
        fun sum(a: Int, b: Int): Int {
            return a + b
        }
    }

    fun sumWithMax(a: Int): Int {
        return max + a
    }
}

object Database {
    init {
        println("Database created")
    }
}

class User(var firstname: String, var lastName: String, var age: Int) {
    lateinit var favoriteMovie: String
    init {
        println("User: $firstname was created")
    }
}
