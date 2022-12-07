fun learnAbstractClass(){

}

abstract class Vehicle2(){
    abstract fun move()

    abstract fun stop()
}

class Car2(var name: String, var color: String, val engines: Int, val doors: Int): Vehicle2() {
    override fun move() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }
}
