import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ComplexSystemStore(private val filePath: String) {
    private val cache: HashMap<String, String> = HashMap()

    fun store(key: String, value: String) {
        cache[key] = value
    }

    fun read(key: String): String {
        return cache[key] ?: ""
    }

    fun commit() = println("Storing cached data to file $filePath")
}

data class User(val login: String)

// Facade
class UserRepository {
    private val systemPreferences = ComplexSystemStore("/data/default.prefs")

    fun save(user: User) {
        systemPreferences.store("USER_KEY", user.login)
        systemPreferences.commit()
    }

    fun findFirst(): User = User(systemPreferences.read("USER_KEY"))
}

class FacadeTest {
    @Test
    fun testFacade() {
        val userRepository = UserRepository()
        val user = User("user1")
        userRepository.save(user)
        val user2 = userRepository.findFirst()
        assertEquals("user1", user2.login)
    }
}
