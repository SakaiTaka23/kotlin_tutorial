import kotlin.test.Test

data class Memento(val state: String)

class Originator(var state: String) {
    fun createMemento(): Memento = Memento(state)
    fun restore(memento: Memento) {
        state = memento.state
    }
}

class CareTaker {
    private val mementoList = arrayListOf<Memento>()

    fun saveState(state: Memento) {
        mementoList.add(state)
    }

    fun restore(index: Int): Memento = mementoList[index]
}

class MementoTest {
    @Test
    fun testMemento() {
        val originator = Originator("State 1")
        val careTaker = CareTaker()

        careTaker.saveState(originator.createMemento())
        originator.state = "State 2"
        careTaker.saveState(originator.createMemento())
        originator.state = "State 3"
        careTaker.saveState(originator.createMemento())

        assert(originator.state == "State 3")

        originator.restore(careTaker.restore(1))
        assert(originator.state == "State 2")

        originator.restore(careTaker.restore(0))
        assert(originator.state == "State 1")
    }
}
