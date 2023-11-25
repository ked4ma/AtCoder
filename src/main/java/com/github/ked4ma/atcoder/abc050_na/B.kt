package com.github.ked4ma.atcoder.abc050_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    nextInt()
    val ts = nextIntList()
    val sum = ts.sum()
    repeat(nextInt()) {
        val (p, x) = nextIntList()
        println(sum - ts[p - 1] + x)
    }
}
