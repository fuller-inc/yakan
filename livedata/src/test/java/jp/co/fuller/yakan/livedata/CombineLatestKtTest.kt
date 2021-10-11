package jp.co.fuller.yakan.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CombineLatestKtTest {
    @Test
    fun testCombineLatest_TwoValues_emitNone() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2
        ) { data1, data2 ->
            data1 + data2
        }
        assertNull(target.value)
    }

    @Test
    fun testCombineLatest_TwoValues_emitOneValueIsNull() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2
        ) { data1, data2 ->
            data1 + data2
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_TwoValues_emitTwoValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2
        ) { data1, data2 ->
            data1 + data2
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 1
        assertEquals("test1", received)
    }

    @Test
    fun testCombineLatest_ThreeValues_emitNone() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2, mutableLiveData3
        ) { data1, data2, data3 ->
            data1 + (data2 * data3)
        }
        assertNull(target.value)
    }

    @Test
    fun testCombineLatest_ThreeValues_emitOneValue() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2, mutableLiveData3
        ) { data1, data2, data3 ->
            data1 + (data2 * data3)
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_ThreeValues_emitTwoValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2, mutableLiveData3
        ) { data1, data2, data3 ->
            data1 + (data2 * data3)
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 2
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_ThreeValues_emitThreeValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1, mutableLiveData2, mutableLiveData3
        ) { data1, data2, data3 ->
            data1 + (data2 * data3)
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 2
        mutableLiveData3.value = 3
        assertEquals("test6", received)
    }

    @Test
    fun testCombineLatest_FourValues_emitNone() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val mutableLiveData4 = MutableLiveData<String>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1,
            mutableLiveData2,
            mutableLiveData3,
            mutableLiveData4,
        ) { data1, data2, data3, data4 ->
            data1 + (data2 * data3) + data4
        }
        assertNull(target.value)
    }

    @Test
    fun testCombineLatest_FourValues_emitOneValue() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val mutableLiveData4 = MutableLiveData<String>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1,
            mutableLiveData2,
            mutableLiveData3,
            mutableLiveData4,
        ) { data1, data2, data3, data4 ->
            data1 + (data2 * data3) + data4
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_FourValues_emitTwoValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val mutableLiveData4 = MutableLiveData<String>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1,
            mutableLiveData2,
            mutableLiveData3,
            mutableLiveData4,
        ) { data1, data2, data3, data4 ->
            data1 + (data2 * data3) + data4
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 2
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_FourValues_emitThreeValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val mutableLiveData4 = MutableLiveData<String>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1,
            mutableLiveData2,
            mutableLiveData3,
            mutableLiveData4,
        ) { data1, data2, data3, data4 ->
            data1 + (data2 * data3) + data4
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 2
        mutableLiveData3.value = 3
        assertEquals("", received)
    }

    @Test
    fun testCombineLatest_FourValues_emitFourValues() {
        val mutableLiveData1 = MutableLiveData<String>()
        val mutableLiveData2 = MutableLiveData<Int>()
        val mutableLiveData3 = MutableLiveData<Long>()
        val mutableLiveData4 = MutableLiveData<String>()
        val target: LiveData<String> = combineLatest(
            mutableLiveData1,
            mutableLiveData2,
            mutableLiveData3,
            mutableLiveData4,
        ) { data1, data2, data3, data4 ->
            data1 + (data2 * data3) + data4
        }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData1.value = "test"
        mutableLiveData2.value = 2
        mutableLiveData3.value = 3
        mutableLiveData4.value = "four"
        assertEquals("test6four", received)
    }
}
