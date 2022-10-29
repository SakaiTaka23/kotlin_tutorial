fun main(args: Array<String>) {
    val user = User("lex", "Dobinica", 23)
    println("Name: ${user.name}")
}

class User(name: String, var lastName: String, var age: Int) {
    var name: String

    init {
        if (name.lowercase().startsWith("a")){
            this.name = name
        } else {
            this.name = "User"
            println("The name doesn't start with the letter 'a' or 'A'")
        }
    }
}
