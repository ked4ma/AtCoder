package com.github.ked4ma.atcoder.abc060_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    val (a, b, c) = nextList()
    println(if (a.last() == b.first() && b.last() == c.first()) "YES" else "NO")
}
