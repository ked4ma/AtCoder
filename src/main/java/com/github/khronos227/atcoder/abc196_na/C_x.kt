package com.github.khronos227.atcoder.abc196_na

import com.github.khronos227.atcoder.utils.*

fun main() {
    val n = nextLong()
    var count = 0
    var i = 1
    while (true) {
        val m = i.toString().let {
            it + it
        }.toLong()
        if (n >= m) {
            count++
        } else {
            break
        }
        i++
    }
    println(count)
}
