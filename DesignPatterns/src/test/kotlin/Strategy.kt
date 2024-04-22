import kotlin.test.Test

class Printer(private val stringFormatterStrategy: (String) -> String) {
    fun printString(message: String) {
        println(stringFormatterStrategy(message))
    }
}

val lowercaseFormatter = {message: String -> message.lowercase()}
val uppercaseFormatter = {message: String -> message.uppercase()}

class StrategyTest {
    @Test
    fun testStrategy() {
        val printer = Printer(lowercaseFormatter)
        printer.printString("Hello")
        printer.printString("World")

        val printer2 = Printer(uppercaseFormatter)
        printer2.printString("Hello")
        printer2.printString("World")
    }
}
