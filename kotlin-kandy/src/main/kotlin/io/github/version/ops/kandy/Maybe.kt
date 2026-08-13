package io.github.version.ops.kandy


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
    val present get() = this is Some

    fun getOrNull(): R? = when (this) {
        is Some -> value
        Empty -> null
    }

    fun get(): R = when (this) {
        is Some -> value
        Empty -> throw NoSuchElementException("No value present")
    }
}

object Empty : Maybe<Nothing>()
data class Some<out R>(val value: R) : Maybe<R>()

fun <T> T?.toMaybe(): Maybe<T> =
    when (this) {
        null -> Empty
        else -> Some(this)
    }
