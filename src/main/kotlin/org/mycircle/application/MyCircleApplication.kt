package org.mycircle.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.PropertySource
import org.springframework.context.annotation.PropertySources

@SpringBootApplication
@ComponentScan("org.mycircle", "com.auth0.spring.security.api")
@EnableAutoConfiguration
@PropertySources(PropertySource("classpath:application.properties"),
        PropertySource("classpath:auth0.properties"))
open class MyCircleApplication

fun main(args: Array<String>) {
    SpringApplication.run(MyCircleApplication::class.java, *args)
}

