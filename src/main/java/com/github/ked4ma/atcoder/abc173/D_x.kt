package com.github.ked4ma.atcoder.abc173

import com.github.ked4ma.atcoder.utils.input.deprecated.*

fun main() {
    val n = nextInt()
    val list = nextIntList().sorted()

    var res = 0L
    (1 until n).forEach {
        res += list[list.lastIndex - it.div(2)]
    }
    println(res)
}
