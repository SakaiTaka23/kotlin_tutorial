import java.io.File
import kotlin.test.Test

interface EventListener {
    fun update(eventType: String?, file: File?)
}

class EventManager(vararg operations: String) {
    private var listeners = hashMapOf<String, ArrayList<EventListener>>()

    init {
        for (operation in operations) {
            listeners[operation] =  ArrayList()
        }
    }

    fun subscribe(eventType: String?, listener: EventListener) {
        val users = listeners[eventType]
        users?.add(listener)
    }

    fun unsubscribe(eventType: String?, listener: EventListener) {
        val users = listeners[eventType]
        users?.remove(listener)
    }

    fun notify(eventType: String?, file: File?) {
        val users = listeners[eventType]
        users?.let {
            for (listener in it) {
                listener.update(eventType, file)
            }
        }
    }
}

class Editor {
    var events: EventManager = EventManager("open", "save")
    private var file: File? = null

    fun openFile(filePath: String) {
        file = File(filePath)
        events.notify("open", file)
    }

    fun saveFile() {
        if (file != null) {
            file?.let {
                events.notify("save", it)
            }
        }
    }
}

class EmailNotificationListener(private val email: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Email to $email: Someone has performed $eventType operation with the following file: ${file?.name}")
    }
}

class LogOpenListener(private val log: String): EventListener {
    override fun update(eventType: String?, file: File?) {
        println("Save to log $log: Someone has performed $eventType operation with the following file: ${file?.name}")
    }
}

class ObserverTest {
    @Test
    fun testObserver() {
        val editor = Editor()
        editor.events.subscribe("open", LogOpenListener("path/to/log/file.txt"))
        editor.events.subscribe("save", EmailNotificationListener("test@test.com"))

        editor.openFile("test.txt")
        editor.saveFile()
    }
}
