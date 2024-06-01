package com.github.ked4ma.atcoder.utils.debug

import java.util.*

// Debug Functions
// set "_debug_" prefix for delete this output for submit.

// # Output
@Suppress("FunctionName")
fun _debug_print(data: Any) = print("[DEBUG] $data")

@Suppress("FunctionName", "UNCHECKED_CAST")
fun _debug_println(data: Any, padding: Int? = null) {
    when {
        data is Array<*> && data.isArrayOf<Array<out Number>>() -> {
            val p = (data as Array<Array<out Number>>).maxOf { row ->
                row.maxOf { it.toString().length }
            }
            _debug_println("=== 2D Array ==========")
            data.forEach {
                _debug_println(it, p)
            }
            _debug_println("=======================")
        }

        data is Array<*> && data.isArrayOf<Number>() -> {
            val str = if (padding == null) {
                data.joinToString(", ")
            } else {
                StringJoiner(", ").apply {
                    (data as Array<out Number>).forEach { d ->
                        add("%${padding}s".format(d.toString()))
                    }
                }.toString()
            }
            _debug_println(str)
        }

        else -> println("[DEBUG] $data")
    }
}

@Suppress("FunctionName")
fun _debug_require(value: Boolean, lazyMessage: () -> Any) = require(value, lazyMessage)

@Suppress("FunctionName")
fun _debug_to_bit(n: Long): CharSequence {
    var m = n
    val sb = StringBuilder()
    while (m > 0) {
        sb.append(if (m % 2 == 1L) '1' else '0')
        m = m shr 1
    }
    return sb.reversed()
}