package io.github.version.ops.kandy

import io.kotest.assertions.AssertionErrorBuilder.Companion.fail
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class OptionalTest : FunSpec({

    test("Optional present fold works") {
        var itRan = false
        val value = "abc"
        val o = Optional.ofNullable(value)
        o.fold(
            onPresent = {
                value shouldBe it
                itRan = true
            },
            onEmpty = { fail("on empty shouldn't run") }
        )

        itRan shouldBe true
    }

    test("Optional empty fold works") {
        var itRan = false

        val o = Optional.ofNullable(null as String?)
        o.fold(
            onPresent = { fail("value shouldn't be present") },
            onEmpty = { itRan = true }
        )

        itRan shouldBe true
    }

    test("toOptional works") {
        val o = "abc".toOptional()
        o.isPresent shouldBe true
        o.get() shouldBe "abc"

        val e = (null as String?).toOptional()
        e.isPresent shouldBe false
        e.getOrNull() shouldBe null
    }
})