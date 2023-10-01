package com.github.ked4ma.atcoder.abc057_na

import com.github.ked4ma.atcoder.utils.input.default.*
import kotlin.math.log10
import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    val n = nextLong()
    val r = sqrt(n.toDouble()).toInt()
    for (i in (r downTo 1)) {
        if (n % i != 0L) continue
        println(
            max(
                log10(i.toDouble()).toInt() + 1,
                log10((n / i).toDouble()).toInt() + 1
            )
        )
        break
    }
}
