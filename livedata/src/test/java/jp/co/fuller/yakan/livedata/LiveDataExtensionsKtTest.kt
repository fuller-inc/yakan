package jp.co.fuller.yakan.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LiveDataExtensionsKtTest {
    @Test
    fun testMap_emitNone() {
        val mutableLiveData = MutableLiveData<Int>()
        val target: LiveData<String> = mutableLiveData
            .map(Int::toString)
        assertNull(target.value)
    }

    @Test
    fun testMap_emitMappedValue() {
        val mutableLiveData = MutableLiveData<Int>()
        val target: LiveData<String> = mutableLiveData
            .map(Int::toString)
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData.value = 42
        assertEquals("42", received)
    }

    @Test
    fun testMerge_emitNone() {
        val liveData1 = MutableLiveData<String>()
        val liveData2 = MutableLiveData<String>()
        val target: LiveData<String> = merge(liveData1, liveData2)
        assertNull(target.value)
    }

    @Test
    fun testMerge_firstLiveDataEmitted() {
        val liveData1 = MutableLiveData<String>()
        val liveData2 = MutableLiveData<String>()

        val target: LiveData<String> = merge(liveData1, liveData2)
        var received = ""
        target.observeForever {
            received = it
        }
        liveData1.value = "test1"
        assertEquals("test1", received)
    }

    @Test
    fun testMerge_secondLiveDataEmitted() {
        val liveData1 = MutableLiveData<String>()
        val liveData2 = MutableLiveData<String>()

        val target: LiveData<String> = merge(liveData1, liveData2)
        var received = ""
        target.observeForever {
            received = it
        }
        liveData2.value = "test2"
        assertEquals("test2", received)
    }

    @Test
    fun testMerge_ifBothLiveDataEmittedThenItIsLaterValue() {
        val liveData1 = MutableLiveData<String>()
        val liveData2 = MutableLiveData<String>()

        val target: LiveData<String> = merge(liveData1, liveData2)
        var received = ""
        target.observeForever {
            received = it
        }
        liveData1.value = "test1"
        liveData2.value = "test2"
        assertEquals("test2", received)
    }

    @Test
    fun testFilter_emitNone() {
        val mutableLiveData = MutableLiveData<String>()
        val target: LiveData<String> = mutableLiveData
            .filter { it == "some random value" }
        assertNull(target.value)
    }

    @Test
    fun testFilter_emitFiltered() {
        val mutableLiveData = MutableLiveData<String>()
        val target: LiveData<String> = mutableLiveData
            .filter { it == "some random value" }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData.value = "test"
        assertEquals("", received)
    }

    @Test
    fun testFilter_emitNotFiltered() {
        val mutableLiveData = MutableLiveData<String>()
        val target: LiveData<String> = mutableLiveData
            .filter { it == "test" }
        var received = ""
        target.observeForever {
            received = it
        }
        mutableLiveData.value = "test"
        assertEquals("test", received)
    }
}
