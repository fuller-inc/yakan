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

    @Test
    fun testIsNull_returnsTrueIfNull() {
        val target: String?
        target = null

        val actual = target.isNull()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsNull_returnsFalseIfNotNull() {
        val target: String?
        target = "hello world"

        val actual = target.isNull()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsNotNull_returnsTrueIfNotNull() {
        val target: String?
        target = "hello world"

        val actual = target.isNotNull()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsNotNull_returnsFalseIfNull() {
        val target: String?
        target = null

        val actual = target.isNotNull()
        val expected = false

        assert(actual == expected)
    }
}