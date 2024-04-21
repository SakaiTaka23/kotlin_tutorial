import kotlin.test.Test

interface DataSource

class DatabaseDataSource: DataSource
class NetworkDataSource: DataSource

abstract class DataSourceFactory {
    abstract fun createDataSource(): DataSource

    companion object {
        inline fun <reified  T: DataSource> createFactory(): DataSourceFactory =
            when(T::class) {
                DatabaseDataSource::class -> DatabaseFactory()
                NetworkDataSource::class -> NetworkFactory()
                else -> throw IllegalArgumentException()
            }
    }
}

class DatabaseFactory: DataSourceFactory() {
    override fun createDataSource(): DataSource = DatabaseDataSource()
}

class NetworkFactory: DataSourceFactory() {
    override fun createDataSource(): DataSource = NetworkDataSource()
}

class AbstractFactoryTest {
    @Test
    fun aftest() {
        val databaseFactory = DataSourceFactory.createFactory<DatabaseDataSource>()
        val dataSource = databaseFactory.createDataSource()

        assert(dataSource is DatabaseDataSource)
    }
}
