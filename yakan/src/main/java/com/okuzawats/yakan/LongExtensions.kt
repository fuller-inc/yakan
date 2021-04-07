package com.okuzawats.yakan

/**
 * returns successor of Long value
 *
 * if the value is Long.MAX_VALUE, returns Long.MIN_VALUE
 * @return successor of Long value
 * @see [safeSucc] [pred]
 */
fun Long.succ(): Long = (this + 1)

/**
 * returns successor of Long value, or throws exception if it is Long.MAX_VALUE
 *
 * if the value is Long.MAX_VALUE, throws [IllegalStateException]
 * @return successor of Long value
 * @throws [IllegalStateException]
 * @see [succ] [pred]
 */
fun Long.safeSucc(): Long {
    if (this == Long.MAX_VALUE) {
        throw IllegalStateException("can not create a successor because it is upper bounds.")
    }
    return succ()
}

/**
 * returns predecessor of Long value
 *
 * if the value is Long.MIN_VALUE, returns Long.MAX_VALUE
 * @return predecessor of Long value
 * @see [succ]
 */
fun Long.pred(): Long = (this - 1)

/**
 * returns predecessor of Long value, or throws exception if it is Long.MIN_VALUE
 *
 * if the value is Long.MIN_VALUE, throws [IllegalStateException]
 * @return predecessor of Long value
 * @throws [IllegalStateException]
 * @see [pred] [safeSucc]
 */
fun Long.safePred(): Long {
    if (this == Long.MIN_VALUE) {
        throw IllegalStateException("can not create a successor because it is upper bounds.")
    }
    return pred()
}