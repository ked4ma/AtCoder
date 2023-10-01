package com.github.ked4ma.atcoder.abc195_na

import com.github.ked4ma.atcoder.utils.debug.*
import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.ceil
import kotlin.math.floor

fun main() {
    val (A, B, W) = nextIntList()
    val max = floor(W.toFloat() * 1000 / A).toInt()
    val min = ceil(W.toFloat() * 1000 / B).toInt()
    _debug_println("$min TO $max")
    if (min > max) {
        println("UNSATISFIABLE")
    } else {
        println("$min $max")
    }
}
