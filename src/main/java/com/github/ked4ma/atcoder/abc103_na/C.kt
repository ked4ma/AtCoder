package com.github.ked4ma.atcoder.abc103_na

import com.github.ked4ma.atcoder.utils.*

fun main() {
    nextInt()
    val n = nextLongList()
    println(n.map { it - 1 }.sum())
}
