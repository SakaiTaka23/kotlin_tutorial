fun learnMapping() {
    val numbers = setOf(1,2,3,4,5)
    val numbersTen = numbers.map {
        if (it == 3) {
            it * 100
        } else {
            it * 10
        }
    }
    println(numbersTen)
}
