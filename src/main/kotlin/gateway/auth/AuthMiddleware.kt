package gateway.auth

import org.springframework.stereotype.Component

@Component
class AuthMiddleware {

    fun validate(token: String): AuthContext {
        val claims = JwtValidator.parse(token)
        return AuthContext(
            userId = claims["sub"] as String,
            roles = claims["roles"] as List<String>
        )
    }
}

data class AuthContext(val userId: String, val roles: List<String>)
