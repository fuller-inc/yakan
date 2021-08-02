package jp.co.fuller.yakan

import org.junit.Test
import java.util.Locale

class IntExtensionsTest {
    @Test
    fun testSucc_returnsSuccessor() {
        val target = 42

        val actual = target.succ()
        val expected = 43

        assert(actual == expected)
    }

    @Test
    fun testSucc_overflowsIfMaxValue() {
        val target = Int.MAX_VALUE

        val actual = target.succ()
        val expected = Int.MIN_VALUE

        assert(actual == expected)
    }

    @Test
    fun testSafeSucc_returnsSuccessor() {
        val target = 42

        val actual = target.safeSucc()
        val expected = 43

        assert(actual == expected)
    }

    @Test(expected = IllegalStateException::class)
    fun testSafeSucc_throwExceptionIfMaxValue() {
        val target = Int.MAX_VALUE

        val actual = target.safeSucc()
    }

    @Test
    fun testHasSucc_returnsTrueIfNotMaxValue() {
        val target = 42

        val actual = target.hasSucc()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testHasSucc_returnsFalseIfMaxValue() {
        val target = Int.MAX_VALUE

        val actual = target.hasSucc()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testPred_returnsPredecessor() {
        val target = 42

        val actual = target.pred()
        val expected = 41

        assert(actual == expected)
    }

    @Test
    fun testPred_overflowsIfMinValue() {
        val target = Int.MIN_VALUE

        val actual = target.pred()
        val expected = Int.MAX_VALUE

        assert(actual == expected)
    }

    @Test
    fun testSafePred_returnsPredecessor() {
        val target = 42

        val actual = target.safePred()
        val expected = 41

        assert(actual == expected)
    }

    @Test(expected = IllegalStateException::class)
    fun testSafePred_throwExceptionIfMinValue() {
        val target = Int.MIN_VALUE

        val actual = target.safePred()
    }

    @Test
    fun testHasPred_returnsTrueIfNotMinValue() {
        val target = 42

        val actual = target.hasPred()
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testHasPred_returnsFalseIfMinValue() {
        val target = Int.MIN_VALUE

        val actual = target.hasPred()
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsEven_returnsTrueIsEven() {
        val target = 0

        val actual = target.isEven
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsEven_returnsFalseIsOdd() {
        val target = 1

        val actual = target.isEven
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testIsOdd_returnsTrueIsOdd() {
        val target = 1

        val actual = target.isOdd
        val expected = true

        assert(actual == expected)
    }

    @Test
    fun testIsOdd_returnsFalseIsEven() {
        val target = 0

        val actual = target.isOdd
        val expected = false

        assert(actual == expected)
    }

    @Test
    fun testToStringWithSeparator_returnsWithJpDelimiters() {
        val target = 123456

        val actual = target.toSeparatedString(Locale.JAPAN)
        val expected = "123,456"

        assert(actual == expected)
    }

    @Test
    fun testToStringWithSeparator_returnsWithGermanDelimiters() {
        val target = 123456

        val actual = target.toSeparatedString(Locale.GERMAN)
        val expected = "123.456"

        assert(actual == expected)
    }
}

