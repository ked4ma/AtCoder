package com.github.khronos227.atcoder.abc186

import com.github.khronos227.atcoder.utils.*
import kotlin.math.min

fun main() {
    val (h, w) = nextIntList()
    var sum = 0
    var m = Int.MAX_VALUE
    repeat(h) {
        val list = nextIntList()
        sum += list.sum()
        m = min(m, list.min() ?: Int.MAX_VALUE)
    }
    println(sum - m * h * w)
}
