import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

// 3rd party functionality
data class DisplayDataType(val index: Float, val data: String)

class DataDisplay {
    fun displayData(data: DisplayDataType) {
        println("Index: ${data.index}, Data: ${data.data}")
    }
}

// our code
data class DatabaseData(val position: Int, val amount: Int)

class DatabaseDataGenerator {
    fun generateData(): List<DatabaseData> {
        val list = arrayListOf<DatabaseData>()
        list.add(DatabaseData(1, 100))
        list.add(DatabaseData(2, 200))
        list.add(DatabaseData(3, 300))
        return list
    }
}

interface DatabaseDataConverter {
    fun convertData(data: List<DatabaseData>): List<DisplayDataType>
}

class DataDisplayAdapter(private val display: DataDisplay): DatabaseDataConverter {
    override fun convertData(data: List<DatabaseData>): List<DisplayDataType> {
        val returnList = arrayListOf<DisplayDataType>()
        data.forEach() {
            val displayData = DisplayDataType(it.position.toFloat(), it.amount.toString())
            display.displayData(displayData)
            returnList.add(displayData)
        }
        return returnList
    }
}

class AdapterTest {
    @Test
    fun testAdapter() {
        val display = DataDisplay()
        val adapter = DataDisplayAdapter(display)
        val generator = DatabaseDataGenerator()
        val data = generator.generateData()
        val convertedData = adapter.convertData(data)

        assertEquals(3, convertedData.size)
        assertEquals(1.0f, convertedData[0].index)
    }
}
