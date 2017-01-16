package org.mycircle.application

import com.auth0.spring.security.api.Auth0SecurityConfig
import org.mycircle.security.Auth0Client
import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity



@Configuration
@EnableWebSecurity(debug = true)
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class AppConfig : Auth0SecurityConfig() {

    /**
     * Provides Auth0 API access
     */
    @Bean
    fun auth0Client(): Auth0Client {
        return Auth0Client(clientId, issuer)
    }

    /**
     * Our API Configuration - for Profile CRUD operations

     * Here we choose not to bother using the `auth0.securedRoute` property configuration
     * and instead ensure any unlisted endpoint in our config is secured by default
     */
    @Throws(Exception::class)
    override fun authorizeRequests(http: HttpSecurity) {
        http.authorizeRequests()
                .anyRequest().authenticated()
    }

    /*
     * Only required for sample purposes..
     */
    fun getAuthorityStrategy(): String = super.authorityStrategy
}
