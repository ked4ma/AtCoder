package com.github.khronos227.atcoder.abc109_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val (_, X) = nextLongList()
    val list = (nextLongList() + X).sorted()
    val diff = (0 until list.size - 1).map {
        list[it + 1] - list[it]
    }
    var n = diff.first()
    diff.forEach {
        n = gcd(n, it)
    }
    println(n)
}
