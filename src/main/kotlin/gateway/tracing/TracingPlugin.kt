package gateway.tracing

import io.opentelemetry.api.GlobalOpenTelemetry
import io.opentelemetry.api.trace.SpanKind

class TracingPlugin {

    private val tracer = GlobalOpenTelemetry.getTracer("apollo-gateway")

    fun onRequest(request: GraphQLRequest): GraphQLRequest {
        val span = tracer.spanBuilder(request.operationName ?: "anonymous")
            .setSpanKind(SpanKind.SERVER)
            .startSpan()
        request.attributes["span"] = span
        return request
    }

    fun onResponse(response: GraphQLResponse) {
        val span = response.request.attributes["span"]
        span?.end()
    }
}
