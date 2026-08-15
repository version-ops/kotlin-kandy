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
    object Empty : Maybe<Nothing>() {
        override fun toString() = "Empty"
    }
    data class Some<R>(val value: R) : Maybe<R>() {
        override fun toString() = "Some($value)"
    }

    val present get() = this is Some

    fun get(): R =
        when (this) {
            is Some -> value
            Empty -> throw NoSuchElementException("No value present")
        }

    fun getOrNull(): R? =
        when (this) {
            is Some -> value
            Empty -> null
        }

    /**
     * retrieve value or call lamba to produce value
     */
    fun getOrElse(f: () -> @UnsafeVariance R): R =
        when (this) {
            is Some -> value
            is Empty -> f()
        }

    fun getOrElse(that: @UnsafeVariance R): R =
        when (this) {
            is Some -> value
            Empty -> that
        }

    companion object {
        fun <T> T?.toMaybe(): Maybe<T> =
            when (this) {
                null -> Empty
                else -> Some(this)
        }
    }
}
