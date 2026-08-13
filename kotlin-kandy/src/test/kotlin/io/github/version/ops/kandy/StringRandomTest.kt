package io.github.version.ops.kandy

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.withClue
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringRandomTest : FunSpec({
    test("Generate numeric") {
        fun test(width: Int) {
            val value = RandomValues.numeric(width)
            withClue("Failed for width: $width and result = $value") {
                (value.size == 0 || value.isNumeric) shouldBe true
                value.size shouldBe width
            }
        }

        test(0)
        test(1)
        test(234)
        shouldThrow<IllegalArgumentException> {
            test(-1)
        }
    }

    test("generate alpha") {
        fun test(width: Int) {
            val value = RandomValues.alpha(width)
            withClue("Failed for width: $width and result = $value") {
                (value.size == 0 || value.isAlpha) shouldBe true
                value.size shouldBe width
            }
        }

        test(0)
        test(1)
        test(123)
    }

    test("generate alphaNumeric") {
        fun test(width: Int) {
            val value = RandomValues.alphaNumeric(width)
            withClue("Failed for width: $width and result = $value") {
                (value.size == 0 || value.isAlphaNumeric) shouldBe true
                value.size shouldBe width
            }
        }

        test(0)
        test(1)
        test(123)
    }
})
