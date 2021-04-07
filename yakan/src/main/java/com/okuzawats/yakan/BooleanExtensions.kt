package com.okuzawats.yakan

/**
 * returns true if is not null and is true
 *
 * @return true if not null and is true, else false
 */
fun Boolean?.isTrue(): Boolean = (this != null) && (this == true)

/**
 * returns false if is not null and is false
 *
 * @return true if not null and is false, else false
 */
fun Boolean?.isFalse(): Boolean = (this != null) && (this == false)