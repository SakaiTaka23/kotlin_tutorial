fun main() {
    val user = User("alex", "smth", 30)
    val lazyUser by lazy { User("amdia", "dmai", 4) }
    println(lazyUser.firstname)
}
