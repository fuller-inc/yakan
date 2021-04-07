package com.okuzawats.yakan

/**
 * returns successor of Int value
 *
 * if the value is Int.MAX_VALUE, returns Int.MIN_VALUE
 * @return successor of Int value
 * @see [safeSucc] [pred]
 */
fun Int.succ(): Int = (this + 1)

/**
 * returns successor of Int value, or throws exception if it is Int.MAX_VALUE
 *
 * if the value is Int.MAX_VALUE, throws [IllegalStateException]
 * @return successor of Int value
 * @throws [IllegalStateException]
 * @see [succ] [pred]
 */
fun Int.safeSucc(): Int {
    if (this == Int.MAX_VALUE) {
        throw IllegalStateException("can not create a successor because it is upper bounds.")
    }
    return succ()
}

/**
 * returns predecessor of Int value
 *
 * if the value is Int.MIN_VALUE, returns Int.MAX_VALUE
 * @return predecessor of Int value
 * @see [succ]
 */
fun Int.pred(): Int = (this - 1)

/**
 * returns predecessor of Int value, or throws exception if it is Int.MIN_VALUE
 *
 * if the value is Int.MIN_VALUE, throws [IllegalStateException]
 * @return predecessor of Int value
 * @throws [IllegalStateException]
 * @see [pred] [safeSucc]
 */
fun Int.safePred(): Int {
    if (this == Int.MIN_VALUE) {
        throw IllegalStateException("can not create a successor because it is upper bounds.")
    }
    return pred()
}