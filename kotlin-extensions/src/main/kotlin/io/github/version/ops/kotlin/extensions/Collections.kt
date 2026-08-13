package io.github.version.ops.kotlin.extensions

/**
 * tl;dr is to hide the imperative coding that kotlin forces on the user
 */
object Collections {

    /**
     * traverse list until a result is found
     */
    fun <T, R> List<T>.until(compute: (T) -> io.github.version.ops.kotlin.extensions.Maybe<R>): io.github.version.ops.kotlin.extensions.Maybe<R> {
        for (t in this) {
            compute(t).let { if (it.present) return it }
        }
        return _root_ide_package_.io.github.version.ops.kotlin.extensions.Empty
    }
}
