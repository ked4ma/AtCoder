package com.github.khronos227.atcoder.abc105_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    var n = nextLong()
    val ans = mutableListOf<Char>()

    do {
        if (n % 2 == 0L) {
            ans.add('0')
        } else {
            ans.add('1')
            n--
        }
        n /= -2
    } while (n != 0L)
    println(ans.asReversed().joinToString(""))
}
