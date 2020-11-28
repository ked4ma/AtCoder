package com.github.khronos227.atcoder.abc103_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    nextInt()
    val n = nextLongList()
    println(n.map { it - 1 }.sum())
}
