package com.github.khronos227.atcoder.abc052_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (_, a, b) = nextLongList()
    val x = nextLongList()
    var ans = 0L
    repeat(x.size - 1) {
        val walk = (x[it + 1] - x[it]) * a
        ans += if (walk < b) {
            walk
        } else {
            b
        }
    }
    println(ans)
}
