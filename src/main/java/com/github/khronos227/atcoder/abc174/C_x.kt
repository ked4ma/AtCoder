package com.github.khronos227.atcoder.abc174

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextInt()
    val l = 9 * if (n % 7 == 0) {
        n / 7
    } else {
        n
    }
    var v = 1
    var count = 0
    repeat(n) {
        v = v.times(10).rem(l)
        count++
        if (v == 1) {
            println(count)
            return
        }
    }
    println(-1)
}
