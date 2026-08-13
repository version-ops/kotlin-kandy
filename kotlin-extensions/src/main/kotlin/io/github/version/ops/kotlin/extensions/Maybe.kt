package io.github.version.ops.kotlin.extensions


/**
 * isPresent attempts to make nullable kotlin values more functional
 * to avoid using comparisons to null in the source code.
 * If the value is non-null, it will return a true.
 */
val Any?.isPresent: Boolean
    get() = this != null

val Any?.isNotPresent: Boolean
    get() = this == null

/**
 * better optional
 */
sealed class Maybe<out R> {
    val present get() = this is io.github.version.ops.kotlin.extensions.Some

    fun getOrNull(): R? = when (this) {
        is io.github.version.ops.kotlin.extensions.Some -> value
        _root_ide_package_.io.github.version.ops.kotlin.extensions.Empty -> null
    }

    fun get(): R = when (this) {
        is io.github.version.ops.kotlin.extensions.Some -> value
        _root_ide_package_.io.github.version.ops.kotlin.extensions.Empty -> throw NoSuchElementException("No value present")
    }
}

object Empty : io.github.version.ops.kotlin.extensions.Maybe<Nothing>()
data class Some<out R>(val value: R) : io.github.version.ops.kotlin.extensions.Maybe<R>()

fun <T> T?.toMaybe(): io.github.version.ops.kotlin.extensions.Maybe<T> =
    when (this) {
        null -> _root_ide_package_.io.github.version.ops.kotlin.extensions.Empty
        else -> _root_ide_package_.io.github.version.ops.kotlin.extensions.Some(this)
    }
