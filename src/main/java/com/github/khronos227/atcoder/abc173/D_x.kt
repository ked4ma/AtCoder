package com.github.khronos227.atcoder.abc173

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val list = nextIntList().sorted()

    var res = 0L
    (1 until n).forEach {
        res += list[list.lastIndex - it.div(2)]
    }
    println(res)
}
