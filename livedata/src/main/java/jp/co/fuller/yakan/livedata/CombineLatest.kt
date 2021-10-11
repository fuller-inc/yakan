package jp.co.fuller.yakan.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.distinctUntilChanged

/**
 * combine two [LiveData] and returns new value.
 * @param liveData1 LiveData one
 * @param liveData2 LiveData two
 * @return combined LiveData
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any> combineLatest(
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    crossinline block: (LIVE1, LIVE2) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        listOf(liveData1, liveData2).forEach { liveData ->
            addSource(liveData) {
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                if (liveData1Value != null && liveData2Value != null) {
                    value = block(liveData1Value, liveData2Value)
                }
            }
        }
    }.distinctUntilChanged()
}

/**
 * combine three [LiveData] and returns new value.
 * @param liveData1 LiveData one
 * @param liveData2 LiveData two
 * @param liveData3 LiveData three
 * @return combined LiveData
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any, LIVE3 : Any> combineLatest(
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    liveData3: LiveData<LIVE3>,
    crossinline block: (LIVE1, LIVE2, LIVE3) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        listOf(liveData1, liveData2, liveData3).forEach { liveData ->
            addSource(liveData) {
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                val liveData3Value = liveData3.value
                if (liveData1Value != null && liveData2Value != null && liveData3Value != null) {
                    value = block(liveData1Value, liveData2Value, liveData3Value)
                }
            }
        }
    }.distinctUntilChanged()
}


/**
 * combine three [LiveData] and returns new value.
 * @param liveData1 LiveData one
 * @param liveData2 LiveData two
 * @param liveData3 LiveData three
 * @param liveData4 LiveData four
 * @return combined LiveData
 */
inline fun <T : Any, LIVE1 : Any, LIVE2 : Any, LIVE3 : Any, LIVE4 : Any> combineLatest(
    liveData1: LiveData<LIVE1>,
    liveData2: LiveData<LIVE2>,
    liveData3: LiveData<LIVE3>,
    liveData4: LiveData<LIVE4>,
    crossinline block: (LIVE1, LIVE2, LIVE3, LIVE4) -> T
): LiveData<T> {
    return MediatorLiveData<T>().apply {
        listOf(liveData1, liveData2, liveData3, liveData4).forEach { liveData ->
            addSource(liveData) {
                val liveData1Value = liveData1.value
                val liveData2Value = liveData2.value
                val liveData3Value = liveData3.value
                val liveData4Value = liveData4.value
                if (liveData1Value != null && liveData2Value != null && liveData3Value != null && liveData4Value != null) {
                    value = block(liveData1Value, liveData2Value, liveData3Value, liveData4Value)
                }
            }
        }
    }.distinctUntilChanged()
}
