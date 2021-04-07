package com.okuzawats.yakan

/**
 * returns incremented (+1) value
 *
 * if the value is Int.MAX_VALUE, returns Int.MIN_VALUE
 * @return incremented value
 */
fun Int.succ(): Int = (this + 1)