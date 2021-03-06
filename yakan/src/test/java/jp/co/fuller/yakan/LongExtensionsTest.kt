package jp.co.fuller.yakan

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
    fun testHasSucc_returnsTrueIfNotMaxValue() {
        val target = 42L

        val actual = target.hasSucc()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testHasSucc_returnsFalseIfMaxValue() {
        val target = Long.MAX_VALUE

        val actual = target.hasSucc()
        val expected = false

        assert(actual == expected)
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
    }

    @Test
    fun testHasPred_returnsTrueIfNotMinValue() {
        val target = 42L

        val actual = target.hasPred()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testHasPred_returnsFalseIfMinValue() {
        val target = Long.MIN_VALUE

        val actual = target.hasPred()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsEven_returnsTrueIsEven() {
        val target = 0L

        val actual = target.isEven
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsEven_returnsFalseIsOdd() {
        val target = 1L

        val actual = target.isEven
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsOdd_returnsTrueIsOdd() {
        val target = 1L

        val actual = target.isOdd
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsOdd_returnsFalseIsEven() {
        val target = 0L

        val actual = target.isOdd
        val expected = false

        assert(actual == expected)
    }
}
