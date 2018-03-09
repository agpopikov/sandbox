package org.sandbox.samples

import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.DefaultHeaders
import io.ktor.http.HttpStatusCode
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.sandbox.samples.util.loggerFor


class App

fun main(args: Array<String>) {
    val log = loggerFor(App::class)
    embeddedServer(Netty, 8080) {
        install(DefaultHeaders) {
            header("Content-Type", "application/json")
        }
        routing {
            get("/hello") {
                val name = call.parameters["name"]
                log.info("Calling hello for name: {}.", name)
                if (!name.isNullOrEmpty()) {
                    call.respond(HttpStatusCode.OK, """{ "text": "Hello, $name!" }""")
                } else {
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
        }
    }.start(wait = true)
}
