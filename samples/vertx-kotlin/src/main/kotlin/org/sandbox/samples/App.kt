package org.sandbox.samples

fun main(args: Array<String>) {
    val server = vertx.createHttpServer()

    server.requestHandler({ request ->
        val response = request.response()
        response.putHeader("content-type", "text/plain")
        response.end("Hello World!")
    })

    server.listen(8080)
}
