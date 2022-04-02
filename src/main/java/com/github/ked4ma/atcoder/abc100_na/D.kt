package com.github.ked4ma.atcoder.abc100_na

import com.github.ked4ma.atcoder.utils.*
import kotlin.math.max

fun main() {
    val (n, m) = nextIntList()
    val values = (0 until n).map {
        val (x, y, z) = nextLongList()
        Triple(x, y, z)
    }

    var result = 0L
    (0 until 8).forEach {
        val xi = if ((it and 1) > 0) 1 else -1
        val yi = if ((it and 2) > 0) 1 else -1
        val zi = if ((it and 4) > 0) 1 else -1
        result = max(result, values.map { v ->
            xi.times(v.first) + yi.times(v.second) + zi.times(v.third)
        }.sortedDescending().take(m).sum())
    }
    println(result)
}
