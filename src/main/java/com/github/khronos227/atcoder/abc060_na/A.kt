package com.github.khronos227.atcoder.abc060_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (a, b, c) = nextList()
    println(if (a.last() == b.first() && b.last() == c.first()) "YES" else "NO")
}
