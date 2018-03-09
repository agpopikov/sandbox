package org.sandbox.samples.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

inline fun <reified T: Any> loggerFor(c: KClass<T>): Logger = LoggerFactory.getLogger(c::class.java)
