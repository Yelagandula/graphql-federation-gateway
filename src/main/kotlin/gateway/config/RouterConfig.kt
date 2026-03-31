package gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RouterConfig {

    @Bean
    fun apolloRouter(): ApolloRouter {
        return ApolloRouter.builder()
            .supergraphSdl(loadSupergraph())
            .withPlugin(OpenTelemetryPlugin())
            .build()
    }

    private fun loadSupergraph(): String {
        return this::class.java.getResourceAsStream("/supergraph.graphql")
            ?.bufferedReader()?.readText() ?: throw IllegalStateException("Supergraph not found")
    }
}
