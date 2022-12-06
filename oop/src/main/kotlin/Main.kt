fun main() {
    println(Direction.EAST)
    for(direction in Direction.values()) {
        println(direction.direction)
    }
    println(Direction.NORTH.distance)
    Direction.WEST.printData()

    val direction = Direction.EAST

    when(direction) {
        Direction.EAST -> println("The direction is East")
        Direction.WEST -> println("The direction is West")
        Direction.NORTH -> println("The direction is North")
        Direction.SOUTH -> println("The direction is South")
    }
}

enum class Direction(var direction: String, var distance: Int) {
    NORTH("north", 10),
    SOUTH("north", 10),
    EAST("north", 10),
    WEST("north", 10);

    fun printData(){
        println("Direction = $direction and Distance = $distance")
    }
}
