fun main(args: Array<String>) {
    val car1 = Car("Tesla", "S Plaid", "Red", 4)
    car1.move()
    println("Name = ${car1.name}")
}

class Car(var name: String, var model: String, var color: String, var doors: Int) {

    fun move() {
        println("The car is moving")
    }

    fun stop() {
        println("The car has stopped")
    }
}