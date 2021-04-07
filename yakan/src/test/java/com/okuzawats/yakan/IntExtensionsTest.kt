package com.okuzawats.yakan

import org.junit.Test

class IntExtensionsTest {
    @Test
    fun testSucc_returnsIncrementedValue() {
        val target = 42

        val actual = target.succ()
        val expected = 43

        assert(actual == expected)
    }

    @Test
    fun testSucc_overflowsIfIntMaxValue() {
        val target = Int.MAX_VALUE

        val actual = target.succ()
        val expected = Int.MIN_VALUE

        assert(actual == expected)
    }
}