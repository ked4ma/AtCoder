package com.github.ked4ma.atcoder.abc263_na

import com.github.ked4ma.atcoder.utils.input.default.deprecated.*

fun main() {
    var n = nextInt()
    val parents = nextIntList()
    var count = 0
    while (n != 1) {
        n = parents[n - 2]
        count++
    }
    println(count)
}
