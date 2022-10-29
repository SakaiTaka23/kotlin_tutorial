fun main() {
    val sum = Calculator.sum(Calculator.max,9)
    println(sum)
    val cal = Calculator()
    println(cal.sumWithMax(4))
}

class Calculator() {
    companion object {
        var max = 10
        fun sum(a: Int, b: Int): Int {
        return a + b
        }
    }

    fun sumWithMax(a: Int): Int {
        return max + a
    }
}
