package com.okuzawats.yakan

import org.junit.Test

class AnyExtensionsTest {
    @Test
    fun testUnwrap_returnsNonNullValueIfNonNull() {
        val target: String?
        target = "hello world"

        val actual = target.unwrap()
        val expected = "hello world"

        assert(actual == expected)
    }

    @Test(expected = IllegalArgumentException::class)
    fun testUnwrap_throwIllegalArgumentExceptionIfNull() {
        val target: String?
        target = null

        val actual = target.unwrap()
    }
}