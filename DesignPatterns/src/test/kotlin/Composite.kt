import kotlin.test.Test
import kotlin.test.assertEquals

open class Equipment (
    open val price: Int,
    val name: String
)

open class Composite(name: String): Equipment(0, name) {
    private val equipments = ArrayList<Equipment>()

    override val price: Int
        get() = equipments.sumOf { it.price }

    fun add(equipment: Equipment) = apply { equipments.add(equipment) }
}

class Computer: Composite("PC")
class Processor: Equipment(1000, "Processor")
class HardDrive: Equipment(500, "Hard Drive")
class Memory: Composite("Memory")
class Rom: Equipment(200, "ROM")
class Ram: Equipment(300, "RAM")

class CompositeTest {
    @Test
    fun testComposite() {
        val memory = Memory()
            .add(Rom())
            .add(Ram())
        val pc = Computer()
            .add(Processor())
            .add(HardDrive())
            .add(memory)
        println(pc.price)

        assertEquals(2000, pc.price)
        assertEquals("PC", pc.name)
    }
}
