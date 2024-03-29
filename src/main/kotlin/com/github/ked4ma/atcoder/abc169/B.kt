package com.github.ked4ma.atcoder.abc169

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.log10

fun main() {
    val n = nextInt()
    val values = nextLongList().sorted()
    var res = values[0]
    var logRes = log10(res.toDouble())
    (1 until n).forEach {
        logRes += log10(values[it].toDouble())
        res *= values[it]
    }
    when {
        logRes >= 19 || res > 1_000_000_000_000_000_000L -> println(-1)
        else -> println(res)
    }
}
