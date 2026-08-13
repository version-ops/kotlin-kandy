package io.github.version.ops.kotlin.extensions

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ResultTest : FunSpec({

    test("result map works") {
        // Note:  I had problems with this in the past
        // but I'm not seeing any issues now (??)
        val r = "123".toSuccess()
        val r2 = r.map {
            when {
                it.isNumeric -> it.toInt()
                else -> 0
            }
        }.map { it.toString() }
        r shouldBe r2
    }

    test(
        "result failure"
    ) {
        // contrived -- trying to see how this would be used
        try {
            "abc".toInt()
        } catch (t: Throwable) {
            t.toFailure()
        }
    }
})