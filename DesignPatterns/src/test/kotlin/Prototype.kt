import kotlin.test.Test

abstract class Shape: Cloneable {
    var id: String? = null
    var type: String? = null

    abstract fun draw()

    public override fun clone(): Any {
        var clone: Any? = null
        try {
            clone = super.clone()
        } catch (e: CloneNotSupportedException) {
            e.printStackTrace()
    }
    return clone!!
    }
}

class Rectangle: Shape() {
    override fun draw() {
        println("Inside Rectangle::draw() method.")
    }

    init {
        type = "Rectangle"
    }
}

class Square: Shape() {
    override fun draw() {
        println("Inside Square::draw() method.")
    }

    init {
        type = "Square"
    }
}

class Circle: Shape() {
    override fun draw() {
        println("Inside Circle::draw() method.")
    }

    init {
        type = "Circle"
    }
}

object ShapeCache {
    private val shapeMap = mutableMapOf<String?, Shape>()

    fun loadCache() {
        val circle = Circle()
        val rectangle = Rectangle()
        val square = Square()

        shapeMap["1"] = circle
        shapeMap["2"] = rectangle
        shapeMap["3"] = square
    }

    fun getShape(shapeId: String): Shape {
        val cachedShape = shapeMap[shapeId]
        return cachedShape?.clone() as Shape
    }
}

class PrototypeTest {
    @Test fun testPrototype() {
        ShapeCache.loadCache()
        val cloned = ShapeCache.getShape("1")
        assert(cloned.type == "Circle")
    }
}
