package io.github.version.ops.kotlin.extensions


fun <T> T.toSuccess() = Result.success(this)

fun <T : Throwable> T.toFailure() = Result.failure<T>(this)