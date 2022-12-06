fun learnSealedClass() {
    val success = Result.Success("success!")
    val error = Result.Error("error!")

    getData(success)
}

fun getData(result: Result) {
    when(result) {
        is Result.Error -> result.showMessage()
        is Result.Success -> result.showMessage()
    }
}

sealed class Result(val message: String) {
    class Success(message: String): Result(message)
    class Error(message: String): Result(message)

    fun showMessage() {
        println("Result: $message")
    }
}
