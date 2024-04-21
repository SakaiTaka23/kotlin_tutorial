import kotlin.test.Test

interface Image {
    fun display()
}

class RealImage(private val filename: String): Image {
    override fun display() {
        println("Real Image Displaying: $filename")
    }

    private fun loadFromDisk(filename: String) {
        println("Loading $filename")
    }

    init {
        loadFromDisk(filename)
    }
}

class ProxyImage(private val filename: String): Image {
    private var realImage: RealImage? = null
    override fun display() {
        println("Proxy Image Displaying: $filename")
        if (realImage == null) {
            realImage = RealImage(filename)
        }
        realImage!!.display()
    }
}

class ProxyTest {
    @Test
    fun testProxy() {
        val image = ProxyImage("test.jpg")
        image.display()
        image.display()
    }
}
