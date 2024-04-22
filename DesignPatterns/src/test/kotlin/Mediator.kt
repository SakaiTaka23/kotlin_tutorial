import kotlin.test.Test

class ChatUser(private val mediator: Mediator, private val name: String) {
    fun send(msg: String) {
        println("$name: Sending message: $msg")
        mediator.sendMessage(msg, this)
    }

    fun receive(msg: String) {
        println("$name: Received message: $msg")
    }
}

class Mediator {
    private val users = arrayListOf<ChatUser>()

    fun sendMessage(msg: String, user: ChatUser) {
        users
            .filter { it != user }
            .forEach { it.receive(msg) }
    }

    fun addUser(user: ChatUser): Mediator = apply { users.add(user) }
}

class MediatorTest {
    @Test
    fun testMediator() {
        val mediator = Mediator()
        val john = ChatUser(mediator, "John")
        val jane = ChatUser(mediator, "Jane")
        val alice = ChatUser(mediator, "Alice")
        val carol = ChatUser(mediator, "Carol")

        mediator
            .addUser(john)
            .addUser(jane)
            .addUser(alice)
        carol.send("Hello everyone!")
    }
}
