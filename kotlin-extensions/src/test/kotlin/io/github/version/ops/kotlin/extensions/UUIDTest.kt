package io.github.version.ops.kotlin.extensions

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.util.UUID
import java.util.UUID.nameUUIDFromBytes

class UUIDTest : FunSpec({

    test("String toUUID works") {
        val uuid = UUID.randomUUID()
        uuid.toString().toUUID() shouldBe uuid
    }

    test("String toUUID fails with bad uuid") {
        shouldThrow<IllegalArgumentException> {
            "random ramblings".toUUID()
        }
    }

    test("asUUID works on null") {
        val uuid = (null as String?).asUUID()
        uuid.toString().toUUID() shouldBe uuid
    }

    test("sUUID works on String of UUID") {
        val uuid = UUID.randomUUID()
        uuid.toString().asUUID() shouldBe uuid
    }

    test("asUUID works any String") {
        val quote = """
            To succeed in life, you need three things: 
            a wishbone, a backbone, and a funny bone.
            --Reba McEntire
        """.trimIndent()
        quote.asUUID() shouldBe nameUUIDFromBytes(quote.toByteArray())
    }
})
