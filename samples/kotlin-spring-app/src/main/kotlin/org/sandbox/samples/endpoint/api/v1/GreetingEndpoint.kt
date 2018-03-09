package org.sandbox.samples.endpoint.api.v1

import org.sandbox.samples.service.GreetingService
import org.sandbox.samples.util.Response.Companion.from
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/greeting")
class GreetingEndpoint(val service: GreetingService) {

    @GetMapping
    fun greet(@RequestParam(name = "name", required = false) name: String?) = from {
        service.greet(name)
    }
}
