package org.mycircle.application

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan("org.mycircle", "com.auth0.spring.security.api")
@EnableAutoConfiguration
open class MyCircleApplication

fun main(args: Array<String>) {
    SpringApplication.run(MyCircleApplication::class.java, *args)
}

