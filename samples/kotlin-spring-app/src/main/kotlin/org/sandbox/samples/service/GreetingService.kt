package org.sandbox.samples.service

import org.sandbox.samples.util.loggerFor
import org.springframework.stereotype.Service

@Service
class GreetingService {

    private val log = loggerFor(GreetingService::class)

    fun greet(name: String?): String {
        log.info("Greeting user with name: '$name'.")
        if (name.isNullOrEmpty()) {
            throw IllegalArgumentException("Name for greeting can't be empty or null.")
        }
        return "Hello, $name!"
    }
}
