class Car(name: String, var model: String, var color: String, var doors: Int) {
    var name = name.trim()

    fun move() {
        println("The car $name is moving")
    }

    fun stop() {
        println("The car has stopped")
    }
}

class User(var name: String, var lastName: String, var age: Int) {
    lateinit var favoriteMovie: String

}
