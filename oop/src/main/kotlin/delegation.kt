fun learnDelegation() {

}

class App: A by FirstDelegate(), B by SecondDelegate() {
    override fun print() {
        TODO("Not yet implemented")
    }

    override fun print2() {
        TODO("Not yet implemented")
    }
}

interface A {
    fun print()
}

interface B {
    fun print2()
}

open class FirstDelegate: A {
    override fun print() {
        TODO("Not yet implemented")
    }
}

open class SecondDelegate: B {
    override fun print2() {
        TODO("Not yet implemented")
    }
}
