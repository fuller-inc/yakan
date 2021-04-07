package com.okuzawats.yakan

import org.junit.Test

class BooleanExtensionsTest {
    @Test
    fun testIsTrue_returnsTrueIfNotNullAndTrue() {
        val target: Boolean?
        target = true

        val actual = target.isTrue()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsTrue_returnsFalseIfNotNullAndFalse() {
        val target: Boolean?
        target = false

        val actual = target.isTrue()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsTrue_returnsFalseIfNull() {
        val target: Boolean?
        target = null

        val actual = target.isTrue()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsFalse_returnsTrueIfNotNullAndFalse() {
        val target: Boolean?
        target = false

        val actual = target.isFalse()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsFalse_returnsFalseIfNotNullAnTrue() {
        val target: Boolean?
        target = true

        val actual = target.isFalse()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsFalse_returnsFalseIfNull() {
        val target: Boolean?
        target = null

        val actual = target.isFalse()
        val expected = false

        assert(actual == expected)
    }
}