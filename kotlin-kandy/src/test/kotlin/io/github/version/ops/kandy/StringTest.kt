package io.github.version.ops.kandy

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class StringTest : FunSpec({

    test("size works") {
        "".size shouldBe 0
        "abc".size shouldBe 3
    }

    test("toUTF8 works") {
        val quote = """
            If you cannot do great things, do small things
            in a great way.
            --Napoleon Hill
        """.trimIndent()
        quote.toByteArray().toUTF8() shouldBe quote
    }

    test("isNumeric works") {
        "abc".isNumeric shouldBe false
        "123".isNumeric shouldBe true
        "".isNumeric shouldBe false
    }

    test("isAlpha works") {
        "123".isAlpha shouldBe false
        "abc".isAlpha shouldBe true
        "".isAlpha shouldBe false
    }

    test("isAlphaNumeric works") {
        "123".isAlphaNumeric shouldBe true
        "abc".isAlphaNumeric shouldBe true
        "123abc".isAlphaNumeric shouldBe true
        "".isAlphaNumeric shouldBe false
    }
})
