package gateway

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class TracingPluginTest {

    private val plugin = TracingPlugin()

    @Test
    fun `should attach span to request`() {
        val request = GraphQLRequest(operationName = "GetUser")
        val result = plugin.onRequest(request)
        assertNotNull(result.attributes["span"])
    }
}
