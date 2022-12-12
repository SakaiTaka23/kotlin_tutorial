import javax.swing.JToolBar.Separator

fun learnStringRepresentation() {
    val numberStrings = listOf("one", "two", "three", "four")
    val listString = StringBuffer("The list of numbers: ")
    println(numberStrings.joinTo(listString))
    println(numberStrings.joinToString(separator = " | ", "start: ", ": end"))

    val numbers = (1..100).toList()
    println(numbers.joinToString(limit = 25, truncated = "<...>"))
}
