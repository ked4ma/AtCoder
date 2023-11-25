package com.github.ked4ma.atcoder.utils.debug

// Debug Functions
// set "_debug_" prefix for delete this output for submit.

// # Output
@Suppress("FunctionName")
fun _debug_print(data: Any) = print("[DEBUG] $data")

@Suppress("FunctionName")
fun _debug_println(data: Any) = println("[DEBUG] $data")

@Suppress("FunctionName")
fun _debug_require(value: Boolean, lazyMessage: () -> Any) = require(value, lazyMessage)
