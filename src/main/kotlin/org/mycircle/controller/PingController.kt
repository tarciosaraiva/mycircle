package org.mycircle.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PingController {

    @RequestMapping("/ping")
    fun ping(): String = "Not secure endpoint."

    @RequestMapping("/secured/ping")
    fun securePing(): String = "Secure endpoint."

}
