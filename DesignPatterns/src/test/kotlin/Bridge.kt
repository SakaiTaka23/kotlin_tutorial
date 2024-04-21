import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

interface Device {
    var volume: Int
    fun getName(): String
}

class Radio: Device {
    override var volume: Int = 0
    override fun getName(): String = "Radio"
}

class TV: Device {
    override var volume: Int = 0
    override fun getName(): String = "TV"
}

interface Remote {
    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(private val device: Device): Remote {
    override fun volumeUp() {
        if (device.volume < 10) device.volume++
    }

    override fun volumeDown() {
        if (device.volume > 0) device.volume--
    }
}

class BridgeTest {
    @Test
    fun testBridge() {
        val tv = TV()
        val radio = Radio()

        val tvRemote = BasicRemote(tv)
        val radioRemote = BasicRemote(radio)

        assertEquals("TV", tv.getName())

        tvRemote.volumeDown()
        assertEquals(0, tv.volume)
        tvRemote.volumeUp()
        assertEquals(1, tv.volume)

        radio.volume = 10
        radioRemote.volumeUp()
        assertEquals(10, radio.volume)
        radioRemote.volumeDown()
        assertEquals(9, radio.volume)
    }
}
