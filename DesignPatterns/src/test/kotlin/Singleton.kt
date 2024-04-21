import kotlin.test.Test
import kotlin.test.assertSame

object NetworkDriver {
    init {
        println("NetworkDriver created")
    }

    fun log(): NetworkDriver {
        return apply { println("Network driver: $this") }
    }
}

class SingletonTest {
    @Test
    fun testSingleton() {
        val driver1 = NetworkDriver.log()
        val driver2 = NetworkDriver.log()
        assertSame(driver1, driver2)
    }
}
