package com.github.ked4ma.atcoder.abc175

import com.github.ked4ma.atcoder.utils.input.default.*
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
