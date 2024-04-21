import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class Calculator {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }
}

class CalculatorTest {
    @Test
    fun testSum() {
        val calculator = Calculator()
        assertEquals(4, calculator.sum(2, 2))
    }
}
