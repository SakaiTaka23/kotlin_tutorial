fun learnInterfaces() {

}

interface Engine {
    fun startEngine()
}

class Car3(val name: String, val color: String): Engine {
    override fun startEngine() {
        println("The car is starting the engine.")
    }
}

class Truck(val name: String, val color: String): Engine {
    override fun startEngine() {
        println("The truck is starting the engine.")
    }
}

class Plane2(val name: String, val color: String): Engine {
    override fun startEngine() {
        println("The plane is starting the engine.")
    }
}
