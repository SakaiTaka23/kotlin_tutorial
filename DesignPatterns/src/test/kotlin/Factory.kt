import kotlin.test.Test
import kotlin.test.assertEquals

sealed class Country {
    data object Canada: Country()
}

data object Spain: Country()
class Greece(val population: Int): Country()
data class USA(val population: Int): Country()

class Currency(val code: String)

object CurrencyFactory {
    fun currencyForCountry(country: Country): Currency {
        return when (country) {
            is Country.Canada -> Currency("CAD")
            is Spain -> Currency("EUR")
            is Greece -> Currency("EUR")
            is USA -> Currency("USD")
        }
    }
}

class FatoryTest {
    @Test
    fun currencyTest() {
        val greekCurrency = CurrencyFactory.currencyForCountry(Greece(10000000))
        val spainCurrency = CurrencyFactory.currencyForCountry(Spain).code

        assertEquals(greekCurrency.code, "EUR")
        assertEquals(spainCurrency, "EUR")
    }
}
