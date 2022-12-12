fun learnZipping() {
    val colors = listOf("red", "brown", "grey")
    val animals = listOf("fox", "bear", "wolf")

    println(colors.zip(animals))
//    println(colors zip animals)
    println(colors.zip(animals) {
        color, animal -> "The ${animal.replaceFirstChar { it.uppercase() }} is $color"
    })

    val numbers = listOf("one", "two", "three", "four")
    println(numbers.associateWith {
        it.length
    })
    println(numbers.associateBy { it.first().uppercase() })
}
