package com.okuzawats.yakan

/**
 * returns successor of Int value
 *
 * if the value is Int.MAX_VALUE, returns Int.MIN_VALUE
 * @return successor of Int value
 * @see [pred]
 */
fun Int.succ(): Int = (this + 1)

/**
 * returns predecessor of Int value
 *
 * if the value is Int.MIN_VALUE, returns Int.MAX_VALUE
 * @return predecessor of Int value
 * @see [succ]
 */
fun Int.pred(): Int = (this - 1)