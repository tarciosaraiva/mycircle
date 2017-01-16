package org.mycircle.security

import org.springframework.stereotype.Component
import com.auth0.spring.security.api.Auth0JWTToken
import com.auth0.Auth0
import com.auth0.authentication.AuthenticationAPIClient


@Component
class Auth0Client(val clientid: String,
                  val domain: String,
                  val auth0: Auth0 = Auth0(clientid, domain),
                  val client: AuthenticationAPIClient = auth0.newAuthenticationAPIClient()) {

    fun getUsername(token: Auth0JWTToken): String {
        val request = client.tokenInfo(token.jwt)
        val profile = request.execute()
        return profile.email
    }
}
