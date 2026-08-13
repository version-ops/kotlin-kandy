package io.github.version.ops.kotlin.extensions

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.Optional
import kotlin.random.Random

@Suppress("RedundantNullableReturnType")
class MaybeTest : FunSpec({

    test("isPresent works") {
        val nonNullable = "abc"
        nonNullable.isPresent shouldBe true

        val nullable: String? = "abc"
        nullable.isPresent shouldBe true

        val nullVal: String? = null
        nullVal.isPresent shouldBe false
    }

    test("isPresent does not break optional isPresent") {
        val o = Optional.of("abc")
        o.isPresent shouldBe true

        val e: Optional<String> = Optional.ofNullable(null)
        e.isPresent shouldBe false
    }

    test("isNotPresent works") {
        val nonNullable = "abc"
        nonNullable.isNotPresent shouldBe false

        val nullable: String? = "abc"
        nullable.isNotPresent shouldBe false

        val nullVal: String? = null
        nullVal.isNotPresent shouldBe true
    }

    test("basic semantics") {

        val x = Some("Hello")
        x.value shouldBe "Hello"
        x.present shouldBe true

        Empty.present shouldBe false

        val flag = Random.nextBoolean()
        val y = when {
            flag -> Some(flag.toString())
            else -> Empty
        }
        when (y) {
            Some(x) -> x.value shouldBe "true"
            else -> y is Empty
        }
    }

    test("get works as designed") {

        Some("hello").get() shouldBe "hello"

        shouldThrow<NoSuchElementException> {
            Empty.get()
        }
    }
})
