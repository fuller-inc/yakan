package com.okuzawats.yakan

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * Unwrap nullable type to non-null.
 *
 * Calls [requireNotNull] internally, but used as extension function.
 * For example, string.unwrap() returns non-null value if it is non-null.
 * Or throw [IllegalArgumentException] if it is null.
 *
 * @param T the type of nullable value
 * @return non-null value of [T]
 */
fun <T : Any?> T?.unwrap(): T = requireNotNull(this)

@OptIn(ExperimentalContracts::class)
fun <T : Any?> T?.isNull(): Boolean {
    contract {
        returns() implies (this@isNull != null)
    }
    return (this == null)
}