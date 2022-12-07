fun learnDataClass(){
    val user1 = User2("Alex", "Dobbin", 23)
    val user2 = User2("Alex", "Dobbin", 23)

    println(user1 == user2)
    println(user1)
}

data class User2(var firstName: String, var lastName: String, var age: Int) {
//    override fun equals(other: Any?): Boolean {
//        if (this === other) {
//            return true
//        }
//
//        if (other is User2) {
//            return this.firstName == other.firstName
//                    && this.lastName == other.lastName
//                    && this.age == other.age
//        }
//
//        return false
//    }
//
//    override fun hashCode(): Int {
//        return 0
//    }
//
//    override fun toString(): String {
//        return "User(firstName: $firstName, lastName: $lastName, age: $age)"
//    }
}
