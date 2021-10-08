package jp.co.fuller.yakan.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

/**
 * Filter LiveData that emits [T] type value by [predicate].
 *
 * @param T emit data type
 * @param predicate returns LiveData if predicate is true only.
 */
fun <T : Any> LiveData<T>.filter(predicate: (T) -> Boolean): LiveData<T> {
    return MediatorLiveData<T>().also { mediator ->
        mediator.addSource(this) {
            if (predicate.invoke(it)) {
                mediator.value = it
            }
        }
    }
}

/**
 * Merge any number of LiveData that emit a value of type [T], Emit latest values.
 *
 * @param T emit data type
 * @param liveData vararg of LiveData
 */
fun <T : Any> merge(vararg liveData: LiveData<T>): LiveData<T> {
    return MediatorLiveData<T>().apply {
        liveData.forEach {
            addSource(it) { emitted ->
                value = emitted
            }
        }
    }
}

/**
 * An extension function that converts [LiveData] the type parameter [T] to [R]
 */
fun <T, R> LiveData<T>.map(transform: (T) -> R): LiveData<R> {
    return object : MediatorLiveData<R>() {
        init {
            addSource(this@map) {
                value = transform(it)
            }
        }
    }
}
