package com.github.ked4ma.atcoder.abc056_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val x = nextLong()
    var i = 0L
    var sum = 0L

    while (sum < x) {
        sum += ++i
    }

    println(i)
}
