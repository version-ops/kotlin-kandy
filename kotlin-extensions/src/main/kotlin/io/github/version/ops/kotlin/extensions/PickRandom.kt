@file:Suppress("NOTHING_TO_INLINE")

package io.github.version.ops.kotlin.extensions

import io.github.version.ops.kotlin.extensions.pickRandom
import kotlin.collections.Map.Entry

// remember 'random' -> shuffled()

inline fun IntRange.pickRandom(): Int = random()
inline fun LongRange.pickRandom(): Long = random()
inline fun CharRange.pickRandom(): Char = random()
inline fun UIntRange.pickRandom(): UInt = random()
inline fun ULongRange.pickRandom(): ULong = random()

inline fun <T> Collection<T>.pickRandom(): T = random()
inline fun <K, V> Map<K, V>.pickRandom(): Entry<K, V> = entries.pickRandom()

