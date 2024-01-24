package com.github.ked4ma.atcoder.abc109_na

import com.github.ked4ma.atcoder.utils.input.default.*
import com.github.ked4ma.atcoder.utils.math.gcd.*

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
