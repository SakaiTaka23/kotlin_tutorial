import kotlin.test.Test
import kotlin.test.assertNotNull

class AlertBox {
    var message: String? = null

    fun show() {
        println("AlertBox: $message")
    }
}

class Window {
    val box by lazy { AlertBox() }

    fun showMessage(message: String) {
        box.message = message
        box.show()
    }
}

class Window2 {
    lateinit var box: AlertBox

    fun showMessage(message: String) {
        box = AlertBox()
        box.message = message
        box.show()
    }
}

class WindowTest {
    @Test
    fun `test lazy initialization`() {
        val window = Window()
        window.showMessage("Hello, World!")
        assertNotNull(window.box)
    }

    @Test
    fun `test lateinit initialization`() {
        val window = Window2()
        window.showMessage("Hello, World!")
        assertNotNull(window.box)
    }
}
