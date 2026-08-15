package io.github.version.ops.kandy

import io.github.version.ops.kandy.Maybe.Empty

/**
 * tl;dr is to hide the imperative coding that kotlin forces on the user to
 * do continues or early returns.
 */
object Collections {

    /**
     * traverse list until a result is found
     */
    fun <T, R> List<T>.until(compute: (T) -> Maybe<R>): Maybe<R> {
        for (t in this) {
            compute(t).let { if (it.present) return it }
        }
        return Empty
    }
}
