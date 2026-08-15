package io.github.version.ops.kandy

import java.io.Reader

/**'
 * this looses the positional nature that getResourceAsStream, and
 * only works from the base of resource directory
 */
fun String.openResource(): Reader? {
    val resource = when (this.startsWith('/')) {
        true -> this
        else -> "/$this"
    }
    return object {}.javaClass.getResourceAsStream(resource)
        ?.bufferedReader()
}

/**
 * reads the lines or null if not found
 */
fun String.readResource(): List<String>? = this.openResource()?.readLines()
