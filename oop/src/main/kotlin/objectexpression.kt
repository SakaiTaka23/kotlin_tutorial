import java.util.EventListener

fun learnObjectExpression() {
    val clickListener = ClickListener()

    val loginButton = Button("Login", 1234, object : OnClickListener {
        override fun onClick() {
            TODO("Not yet implemented")
        }
    })

    val signUpButton = Button("Sign Up", 2345, object : OnClickListener {
        override fun onClick() {
            TODO("Not yet implemented")
        }
    })
}

class Button(val text: String, val id: Int, onClickListener: OnClickListener) {

}

class ClickListener(): OnClickListener {
    override fun onClick() {

    }

}

interface OnClickListener {
    fun onClick()
}
