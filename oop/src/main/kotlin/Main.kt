fun main(args: Array<String>) {
    val user = User("Alex", "Dobinica", 23)
    val user2 = User(name = "Alex")
    val user3 = User("Alex", "Smith")

    println(user.isAdult)
}

class User(var name: String, var lastName: String = "LastName", var age: Int = 0) {
    val isAdult get() = this.age > 20
}
