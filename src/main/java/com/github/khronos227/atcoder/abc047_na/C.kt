package com.github.khronos227.atcoder.abc047_na

import com.github.khronos227.atcoder.utils.*

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
