package com.okuzawats.yakan

/**
 * Unwrap nullable [Any] to non-null.
 *
 * Calls [requireNotNull] internally, but used as extension function.
 * For example, string.unwrap() returns non-null value if it is non-null.
 * Or throw [IllegalArgumentException] if it is null.
 */
fun Any?.unwrap() = requireNotNull(this)