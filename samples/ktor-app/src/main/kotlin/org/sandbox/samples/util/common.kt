package org.sandbox.samples.util

import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)

fun <T : Any> loggerFor(clazz: KClass<T>) = LoggerFactory.getLogger(clazz.java)
