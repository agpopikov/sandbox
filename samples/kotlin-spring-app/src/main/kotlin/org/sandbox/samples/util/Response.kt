package org.sandbox.samples.util

data class Response(val type: ResponseType, val data: Any?, val error: ResponseError?) {

    companion object {

        fun ok() = Response(ResponseType.OK, null, null)
        fun ok(data: Any) = Response(ResponseType.OK, data, null)
        fun fail(message: String) = Response(ResponseType.ERROR, null, ResponseError(message))
        fun from(f: () -> Any) = {
            try {
                ok(f())
            } catch (e: Exception) {
                fail(if (e.message != null) e.message!! else "Unexpected error occurred.")
            }
        }
    }
}

enum class ResponseType {
    OK, ERROR
}

data class ResponseError(val message: String)
