import kotlin.test.Test

interface HandlerChain {
    fun addHeader(inputHeader: String): String
}

class AuthenticationHeader(val token: String?, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) = "$inputHeader \n Authorization: $token"
        .let { next?.addHeader(it) ?: it }
}

class ContentTypeHeader(val contentType: String, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) = "$inputHeader \n Content-Type: $contentType"
        .let { next?.addHeader(it) ?: it }
}

class BodyPayloadHeader(val body: String, var next: HandlerChain? = null): HandlerChain {
    override fun addHeader(inputHeader: String) = "$inputHeader \n $body"
        .let { next?.addHeader(it) ?: it }
}

class ChainOfResponsibilityTest {
    @Test
    fun testChainOfResponsibility() {
        val authenticationHeader = AuthenticationHeader("Bearer 123")
        val contentTypeHeader = ContentTypeHeader("application/json")
        val bodyPayloadHeader = BodyPayloadHeader("{'name': 'John Doe'}")

        authenticationHeader.next = contentTypeHeader
        contentTypeHeader.next = bodyPayloadHeader

        val messageWithAuthentication = authenticationHeader.addHeader("Request:Authentication")
        println(messageWithAuthentication)
    }
}
