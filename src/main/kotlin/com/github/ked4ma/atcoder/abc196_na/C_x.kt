package com.github.ked4ma.atcoder.abc196_na

import com.github.ked4ma.atcoder.utils.input.default.*

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
