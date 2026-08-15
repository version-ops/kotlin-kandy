package io.github.version.ops.kandy

import java.util.Optional


/**
 * allows the optional instance to handled.
 */
fun <T> Optional<T>.fold(
    onPresent: (T) -> Unit = {},
    onEmpty: () -> Unit = {}
) =
    when (this.isPresent) {
        true -> onPresent(get())
        else -> onEmpty()
    }

fun <T> T?.toOptional(): Optional<T & Any> =
    Optional.ofNullable(this)

