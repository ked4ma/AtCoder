package com.github.khronos227.atcoder.abc048_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (_, x) = nextLongList()
    val v = nextLongList().toLongArray()
    var count = 0L
    (0 until v.lastIndex).forEach { index ->
        if (v[index] > x) {
            val diff = v[index] - x
            count += diff
            v[index] -= diff
        }
        val rest = x - v[index]
        if (v[index + 1] > rest) {
            val diff = v[index + 1] - rest
            count += diff
            v[index + 1] -= diff
        }
    }
    println(count)
}
