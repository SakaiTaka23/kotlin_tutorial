fun learnListSetMap() {
    println("list")
    val namesList = mutableListOf("name1", "name2", "name3", "name3")

    println(namesList[0])
    namesList.add("name4")
    namesList.removeAt(2)
    namesList.remove("name1")
    namesList.forEach { println(it) }

    println("set")
    val names = setOf<String>("name1", "name2", "name1")
    names.forEach { println(it) }

    println("map")
    val users = mapOf<Int, String>(1 to "Maria", 2 to "Alex", 3 to "John")
    println(users[1])
}
