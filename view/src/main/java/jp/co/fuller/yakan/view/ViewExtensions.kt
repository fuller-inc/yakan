package jp.co.fuller.yakan.view

import android.view.View
import java.util.concurrent.atomic.AtomicLong

/**
 * Set view a click listener that ignores "double click" event.
 *
 * Set "double click" ignoring click listener to a View.
 * The phrase "double click" means multiple click event to one view within a certain time interval.
 * @param avoidDoubleClickMillis The time interval ignoring subsequent click events.
 * @param clickListener A Lambda fired when click event that not ignored occurs.
 *
 */
fun View.setOnSingleClickListener(
    avoidDoubleClickMillis: Long = DOUBLE_CLICK_AVOIDING_DELAY_MILLIS,
    clickListener: () -> Unit,
) {
    setOnClickListener(
        SingleClickListener(
            avoidDoubleClickMillis = avoidDoubleClickMillis,
            clickListener = clickListener,
        ),
    )
}

// A subclass of View.OnClickListener that enables only one click event for a certain time period.
// The time period is passed as a parameter of [avoidDoubleClickMillis]. The unit is milliseconds.
// Also you can pass the lambda fired when a click event occurs.
internal class SingleClickListener(
    private val avoidDoubleClickMillis: Long,
    private val clickListener: () -> Unit,
) : View.OnClickListener {

    // A private variable that remember the last clicked time millis.
    // If it is INITIAL_CLICKED_MILLIS (actually, it is zero.), the [clickListener] is fired.
    // If the difference between [lastClickedMillis] and the clicked time millis is within [avoidDoubleClickMillis],
    // the click event is just ignored.
    private var lastClickedMillis = AtomicLong(INITIAL_CLICKED_MILLIS)

    // Callback of click event overriding View.OnClickListener#onClick.
    // This function handles the click event and if the click event is regarded as "double click",
    // the click event is just ignored.
    override fun onClick(view: View) {
        val clickedMillis = System.currentTimeMillis()
        if (clickedMillis - lastClickedMillis.get() >= avoidDoubleClickMillis) {
            clickListener()
            lastClickedMillis.set(clickedMillis)
        }
    }

    companion object {
        // The default time millis. Any value is fine as long as it is small enough.
        private const val INITIAL_CLICKED_MILLIS = 0L
    }
}

// Default time period avoiding double click.
private const val DOUBLE_CLICK_AVOIDING_DELAY_MILLIS = 500L
