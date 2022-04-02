package com.github.ked4ma.atcoder.abc174

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (n, d) = nextLongList()
    val d2 = d * d
    var count = 0
    repeat(n.toInt()) {
        val (x, y) = nextLongList()
        if (x * x + y * y <= d2) {
            count++
        }
    }
    println(count)
}
