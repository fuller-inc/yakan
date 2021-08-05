package jp.co.fuller.yakan.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 * a subtype of [MutableLiveData] that do not hold a value after emitting a value.
 */
class EventLiveData<T : Any> : MutableLiveData<T>() {

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        try {
            val nullIgnoringObserver = NullIgnoringObserver(observer)
            super.observe(owner, nullIgnoringObserver)
        } catch (e: Throwable) {
            throw e
        }
    }

    override fun observeForever(observer: Observer<in T>) {
        try {
            val nullIgnoringObserver = NullIgnoringObserver(observer)
            super.observeForever(nullIgnoringObserver)
        } catch (e: Throwable) {
            throw e
        }
    }

    override fun setValue(value: T?) {
        // set null after emitting a value
        super.setValue(value)
        if (value != null) super.setValue(null)
    }

    // observer that ignore null value
    private class NullIgnoringObserver<T : Any>(val observer: Observer<in T>) : Observer<T?> {
        override fun onChanged(t: T?) {
            if (t != null) observer.onChanged(t)
        }
    }
}
