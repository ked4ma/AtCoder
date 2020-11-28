package com.github.khronos227.atcoder.abc171

import com.github.khronos227.atcoder.utils.*

fun main() {
    var n = nextLong()
    val res = StringBuilder()
    while (n > 0) {
        var m = n % 26
        n /= 26
        if (m == 0L) {
            m = 26
            n--
        }
        res.insert(0, m.plus(96).toChar())
    }
    println(res.toString())
}
