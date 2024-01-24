package com.github.ked4ma.atcoder.abc047_na

import com.github.ked4ma.atcoder.utils.input.default.*

fun main() {
    val s = next()
    var c = s.first()
    var count = 1
    s.forEach {
        if (c != it) {
            c = it
            count++
        }
    }
    println(count - 1)
}
