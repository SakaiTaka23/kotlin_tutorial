fun main(args: Array<String>) {
    val user = User("Alex", "Dobinica", 23)
    val user2 = User("Alex")
    val user3 = User("Alex", "Smith")
}

class User(var name: String, var lastName: String, var age: Int) {
    constructor(name: String) : this(name,"LastName", 0) {
        println("2nd")
    }
    constructor(name: String, lastName: String): this(name, lastName, 0) {
        println("3rd")
    }

//    init {
//        if (name.lowercase().startsWith("a")){
//            this.name = name
//        } else {
//            this.name = "User"
//            println("The name doesn't start with the letter 'a' or 'A'")
//        }
//    }
}
