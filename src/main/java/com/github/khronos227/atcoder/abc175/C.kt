package com.github.khronos227.atcoder.abc175

import com.github.khronos227.atcoder.utils.*
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    val (x, k, d) = nextLongList()
    val a = x.absoluteValue.div(d).coerceAtMost(k)
    var current = x.absoluteValue - a.times(d)
    repeat(k.minus(a).rem(2).toInt()) {
        if (current > 0) {
            current -= d
        } else {
            current += d
        }
    }
    println(abs(current))
}
