import kotlin.test.Test
import kotlin.test.assertEquals

sealed class AuthorizationState

object Unauthorized: AuthorizationState()

class Authorized(val username: String): AuthorizationState()

class AuthorizationPresenter {
    private var state: AuthorizationState = Unauthorized

    val isAuthorized: Boolean
        get() = when (state) {
            is Authorized -> true
            else -> false
        }

    val username: String
        get() = when (state) {
            is Authorized -> (state as Authorized).username
            else -> "Unknown"
        }

    fun loginUser(username: String) {
        state = Authorized(username)
    }

    fun logoutUser() {
        state = Unauthorized
    }

    override fun toString() = "User $username is logged in: $isAuthorized"
}

class StateTest {
    @Test
    fun testState() {
        val authorizationPresenter = AuthorizationPresenter()
        authorizationPresenter.loginUser("John Doe")
        assertEquals("User John Doe is logged in: true", authorizationPresenter.toString())
        authorizationPresenter.logoutUser()
        println(authorizationPresenter)
        assertEquals("User Unknown is logged in: false", authorizationPresenter.toString())
    }
}
