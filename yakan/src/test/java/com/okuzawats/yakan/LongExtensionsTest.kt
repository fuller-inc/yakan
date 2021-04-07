package com.okuzawats.yakan

import org.junit.Test

class LongExtensionsTest {
    @Test
    fun testSucc_returnsSuccessor() {
        val target = 42L

        val actual = target.succ()
        val expected = 43L

        assert(actual == expected)
    }

    @Test
    fun testSucc_overflowsIfMaxValue() {
        val target = Long.MAX_VALUE

        val actual = target.succ()
        val expected = Long.MIN_VALUE

        assert(actual == expected)
    }

    @Test
    fun testSafeSucc_returnsSuccessor() {
        val target = 42L

        val actual = target.safeSucc()
        val expected = 43L

        assert(actual == expected)
    }

    @Test(expected = IllegalStateException::class)
    fun testSafeSucc_throwExceptionIfMaxValue() {
        val target = Long.MAX_VALUE

        val actual = target.safeSucc()
    }

    @Test
    fun testPred_returnsPredecessor() {
        val target = 42L

        val actual = target.pred()
        val expected = 41L

        assert(actual == expected)
    }

    @Test
    fun testPred_overflowsIfMinValue() {
        val target = Long.MIN_VALUE

        val actual = target.pred()
        val expected = Long.MAX_VALUE

        assert(actual == expected)
    }

    @Test
    fun testSafePred_returnsPredecessor() {
        val target = 42L

        val actual = target.safePred()
        val expected = 41L

        assert(actual == expected)
    }

    @Test(expected = IllegalStateException::class)
    fun testSafePred_throwExceptionIfMinValue() {
        val target = Long.MIN_VALUE

        val actual = target.safePred()
    }}